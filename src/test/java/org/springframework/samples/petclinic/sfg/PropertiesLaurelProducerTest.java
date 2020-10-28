package org.springframework.samples.petclinic.sfg;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource("classpath:laurel.properties")
@ActiveProfiles("laurel-properties")
@SpringJUnitConfig(classes = PropertiesLaurelProducerTest.TestConfig.class)
class PropertiesLaurelProducerTest {

    @Autowired
    private HearingInterpreter hearingInterpreter;

    @Configuration
    @ComponentScan(basePackages = "org.springframework.samples.petclinic.sfg")
    static class TestConfig {
    }

    @Test
    void getWord() {
        assertEquals("LaurelProps", hearingInterpreter.whatIheard());
    }
}