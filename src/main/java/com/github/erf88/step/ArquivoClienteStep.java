package com.github.erf88.step;

import com.github.erf88.model.in.ClienteIn;
import com.github.erf88.model.out.ClienteOut;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoClienteStep {

    @Bean
    public Step clienteStep(
            StepBuilderFactory stepBuilderFactory,
            MultiResourceItemReader<ClienteIn> clienteReader,
            ItemProcessor<ClienteIn, ClienteOut> clienteProcessor,
            MultiResourceItemWriter<ClienteOut> clienteWriter) {

        return stepBuilderFactory
                .get("clienteStep")
                .<ClienteIn, ClienteOut>chunk(200)
                .reader(clienteReader)
                .processor(clienteProcessor)
                .writer(clienteWriter)
                .build();
    }

}
