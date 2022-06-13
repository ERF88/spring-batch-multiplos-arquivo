package com.github.erf88.writer;

import com.github.erf88.model.out.ClienteOut;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.builder.MultiResourceItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ArquivoClienteWriter {

    @Value("${spring.batch.file.clientes.out}")
    private Resource resource;

    @Bean
    public MultiResourceItemWriter<ClienteOut> clienteWriter() {
        return new MultiResourceItemWriterBuilder<ClienteOut>()
                .name("clienteWriter")
                .resource(resource)
                .delegate(writer())
                .itemCountLimitPerResource(1)
                .resourceSuffixCreator(index -> "-" + index + ".txt")
                .build();
    }

    private FlatFileItemWriter<ClienteOut> writer() {

        return new FlatFileItemWriterBuilder<ClienteOut>()
                .name("clienteWriter")
                .resource(resource)
                .delimited()
                .delimiter(";")
                .names(new String[] {  "id", "nomeCompleto", "email", "dataProcessamento" })
                .build();

    }

}
