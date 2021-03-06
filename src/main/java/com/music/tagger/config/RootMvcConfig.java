package com.music.tagger.config;

import com.music.tagger.controller.dto.SimpleTrackDto;
import com.music.tagger.interceptor.LoggingInterceptor;
import com.music.tagger.persistence.entity.Track;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Slf4j
@Configuration
@EnableJpaRepositories(basePackages = {"com.music.tagger.persistence.repository"})
@EnableTransactionManagement
@EntityScan("com.music.tagger.persistence.entity")
public class RootMvcConfig implements WebMvcConfigurer {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mm = new ModelMapper();

        PropertyMap<SimpleTrackDto, Track> propertyMap = new PropertyMap<SimpleTrackDto, Track>() {
            protected void configure() {
                map().setName(source.getTrackName());
                map().getAlbum().setName(source.getAlbumName());
                map().getArtist().setName(source.getArtistName());

                skip().setAlbum(null);
                skip().setArtist(null);

                skip().getAlbum().setTrackList(null);
                skip().getAlbum().setArtist(null);

                skip().getArtist().setAlbumList(null);
                skip().getArtist().setTrackList(null);
            }
        };

        mm.addMappings(propertyMap);
        return mm;
    }

    @Bean
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }

    @Bean
    public BeanDefinitionRegistryPostProcessor printLoadedBeans() {
        return new BeanDefinitionRegistryPostProcessor() {
            @Override
            public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
                log.trace(Arrays.toString(beanDefinitionRegistry.getBeanDefinitionNames()));
            }

            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
                log.trace(Arrays.toString(configurableListableBeanFactory.getSingletonNames()));
            }
        };
    }
}
