package io.PearseMcLaughlin.FrameDataTool.FrameDataTool.ControllerTests;

import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Controller.FrameDataCalculationController;
import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Entity.CharacterFrameData;
import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Services.FrameDataRetrievalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class FrameDataCalculationControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FrameDataRetrievalService frameDataRetrievalService;

    @InjectMocks
    private FrameDataCalculationController frameDataCalculationController;

    @Before
    public void setup() {
        //process mock annotations
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(frameDataCalculationController).build();
    }

    @Test
    public void getPunishmentTest() throws Exception{
        List<CharacterFrameData> characterFrameData = new ArrayList<>();
        characterFrameData.add(new CharacterFrameData("Akuma", 1, "1", "H", 10, 10, 1, 8, null, 8, null, null));
        characterFrameData.add(new CharacterFrameData("Akuma", 2, "2", "M", 20, 14, 1, 8, null, 8, null, null));

        CharacterFrameData attack = new CharacterFrameData("Akuma", 3, "D+4", "L", 10, 10, -25, 8, null, 8, null, null);

        given(frameDataRetrievalService.getAllCharacterFrames("Akuma")).willReturn(characterFrameData);
        given(frameDataRetrievalService.getAttackFrameData(1)).willReturn(attack);

        mockMvc.perform(get("/FrameDataCalculate/blocked/1/Akuma"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("frames", hasSize(2)))
                .andExpect(view().name("CharacterFrameData"));
    }

    @Test
    public void getFrameTrapTest() throws Exception{
        List<CharacterFrameData> characterFrameData = new ArrayList<>();
        characterFrameData.add(new CharacterFrameData("Akuma", 1, "1", "H", 10, 10, 1, 8, null, 8, null, null));
        characterFrameData.add(new CharacterFrameData("Akuma", 2, "2", "M", 20, 14, 1, 8, null, 8, null, null));

        CharacterFrameData attack = new CharacterFrameData("Akuma", 1, "1", "H", 10, 10, 1, 8, null, 8, null, null);

        given(frameDataRetrievalService.getAllCharacterFrames("Akuma")).willReturn(characterFrameData);
        given(frameDataRetrievalService.getAttackFrameData(1)).willReturn(attack);

        mockMvc.perform(get("/FrameDataCalculate/Trap/1/Akuma"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("frames", hasSize(2)))
                .andExpect(view().name("CharacterFrameData"));
    }

    @Test
    public void getFrameTrapNullTest() throws Exception{
        List<CharacterFrameData> characterFrameData = new ArrayList<>();
        characterFrameData.add(new CharacterFrameData("Akuma", 1, "1", "H", 10, 10, 1, 8, null, 8, null, null));
        characterFrameData.add(new CharacterFrameData("Akuma", 2, "2", "M", 20, 14, 1, 8, null, 8, null, null));

        CharacterFrameData attack = new CharacterFrameData("Akuma", 1, "1", "H", 10, 10, 1, null, "KNOCKDOWN", null, "KNOCKDOWN", null);

        given(frameDataRetrievalService.getAllCharacterFrames("Akuma")).willReturn(characterFrameData);
        given(frameDataRetrievalService.getAttackFrameData(1)).willReturn(attack);

        mockMvc.perform(get("/FrameDataCalculate/Trap/1/Akuma"))
                .andExpect(status().isOk())
                .andExpect(view().name("ErrorTrapPage"));
    }

    @Test
    public void getPunishmentSafeMoveTest() throws Exception{
        List<CharacterFrameData> characterFrameData = new ArrayList<>();
        characterFrameData.add(new CharacterFrameData("Akuma", 1, "1", "H", 10, 10, 1, 8, null, 8, null, null));
        characterFrameData.add(new CharacterFrameData("Akuma", 2, "2", "M", 20, 14, 1, 8, null, 8, null, null));

        CharacterFrameData attack = new CharacterFrameData("Akuma", 3, "D+4", "L", 10, 10, 0, 8, null, 8, null, null);

        given(frameDataRetrievalService.getAllCharacterFrames("Akuma")).willReturn(characterFrameData);
        given(frameDataRetrievalService.getAttackFrameData(1)).willReturn(attack);

        mockMvc.perform(get("/FrameDataCalculate/blocked/1/Akuma"))
                .andExpect(status().isOk())
                .andExpect(view().name("ErrorPunishmentPage"));
    }

}