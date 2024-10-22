package com.obs.OBS.seekerTest;
import static org.mockito.Mockito.when;

import com.obs.OBS.jobSeeker.CONTRACT;
import com.obs.OBS.jobSeeker.Seeker;
import com.obs.OBS.jobSeeker.SeekerDAO;
import com.obs.OBS.jobSeeker.SeekerDTO;
import com.obs.OBS.jobSeeker.SeekerServiceImpl;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SeekerTest {

  @Mock
  SeekerDAO dao;

  @InjectMocks
  SeekerServiceImpl service;
  @Test
  public void shouldCreateSeekerWithSuccess(){
      SeekerDTO expectedDto = SeekerDTO.builder()
          .firstName("Clement")
          .lastName("Nicolas")
          .email("test@mail")
          .password("1234")
          .phoneNumber("0680997009")
          .contractType(Collections.singleton(CONTRACT.FULL))
          .desiredLocations(new HashSet<>(Set.of("Paris", "Ile de france")))
          .build();

      SeekerDTO savedSeeker = service.createSeeker(expectedDto);

    Assertions.assertNotNull(savedSeeker);
    Assertions.assertNotNull(savedSeeker.getEmail());
    Assertions.assertEquals(expectedDto.getEmail(), savedSeeker.getEmail());
  }

  @Test
  public void shouldUpdateUser(){
    String mockId = "1";
   SeekerDTO existingDTO = SeekerDTO.builder()
       .firstName("Clem")
       .lastName("Nico")
       .phoneNumber("06809979987")
       .email("clem@test")
       .contractType(Collections.singleton(CONTRACT.FULL))
       .desiredLocations(Set.of("Paris"))
       .description("")
       .build();

    Seeker existingSeeker = new Seeker();
    existingSeeker.setId(mockId);
    existingSeeker.setFirstName("Clem");
    existingSeeker.setLastName("Nico");
    existingSeeker.setPhoneNumber("06809979987");
    existingSeeker.setEmail("clem@test");
    existingSeeker.setContractType(Collections.singleton(CONTRACT.FULL));
    existingSeeker.setDesiredLocations(Set.of("Paris"));
    existingSeeker.setDescription("");

    when(dao.getById(mockId)).thenReturn(Optional.of(existingSeeker));

    existingDTO.setFirstName("Enzo");
    existingDTO.setEmail("enzo@mail.fr");
    existingDTO.setPhoneNumber("0680997708");

    SeekerDTO updatedSeeker = service.updateSeeker(mockId, existingDTO);


    Assertions.assertNotNull(updatedSeeker);
    Assertions.assertNotNull(updatedSeeker.getEmail());
    Assertions.assertEquals(updatedSeeker.getFirstName(),existingSeeker.getFirstName());
    Assertions.assertEquals(updatedSeeker.getEmail(),existingSeeker.getEmail());
    Assertions.assertEquals(updatedSeeker.getPhoneNumber(),existingSeeker.getPhoneNumber());
  }

}
