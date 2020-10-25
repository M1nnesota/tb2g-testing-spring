package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    @Mock
    private ClinicService clinicService;

    @InjectMocks
    private VetController controller;

    VetControllerTest() {
    }

    @Test
    void showVetList() {
        //given
        List<Vet> vetList = new ArrayList<>();
        vetList.add(new Vet());
        given(clinicService.findVets()).willReturn(vetList);
        Map<String, Object> model = new HashMap<>();
        //when
        String returnedView = controller.showVetList(model);
        //then
        assertEquals(1, model.size());
        assertEquals("vets/vetList", returnedView);
        then(clinicService).should().findVets();
    }

    @Test
    void showResourcesVetList() {
        //given
        List<Vet> vetList = new ArrayList<>();
        vetList.add(new Vet());
        given(clinicService.findVets()).willReturn(vetList);
        //when
        Vets vets = controller.showResourcesVetList();
        //then
        assertEquals(1, vets.getVetList().size());
        then(clinicService).should().findVets();
    }
}