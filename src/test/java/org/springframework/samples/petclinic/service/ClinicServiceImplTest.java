package org.springframework.samples.petclinic.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClinicServiceImplTest {

    @Mock
    private PetRepository repository;

    @InjectMocks
    private ClinicServiceImpl service;

    @Test
    void findPetTypes() {
        //given
        List<PetType> petTypes = Collections.singletonList(new PetType());
        given(repository.findPetTypes()).willReturn(petTypes);
        //when
        Collection<PetType> petTypesReturned = service.findPetTypes();
        //then
        assertEquals(petTypesReturned.size(), petTypes.size());
        verify(repository).findPetTypes();
    }
}