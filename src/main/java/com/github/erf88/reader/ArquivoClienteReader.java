package com.github.erf88.reader;

import com.github.erf88.model.in.ClienteIn;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ArquivoClienteReader {

    @Value("${spring.batch.file.clientes.in}")
    private Resource[] resources;

    @Bean
    public MultiResourceItemReader<ClienteIn> clienteReader() {
        return new MultiResourceItemReaderBuilder<ClienteIn>()
                .name("clienteReader")
                .resources(resources)
                .delegate(reader())
                .build();
    }

    private FlatFileItemReader<ClienteIn> reader() {
        return new FlatFileItemReaderBuilder<ClienteIn>()
                .name("reader")
                .delimited()
                .delimiter(";")
                .names(new String[] {  "id", "nome", "sobrenome", "email", "status" })
                .targetType(ClienteIn.class)
                .build();
    }

}
