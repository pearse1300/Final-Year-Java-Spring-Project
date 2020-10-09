package io.PearseMcLaughlin.FrameDataTool.FrameDataTool.ControllerTests;

import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Controller.FrameDataRetrievalController;
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
public class FrameDataRetrievalControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FrameDataRetrievalService frameDataRetrievalService;

    @InjectMocks
    private FrameDataRetrievalController frameDataRetrievalController;

    @Before
    public void setup(){
        //process mock annotations
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(frameDataRetrievalController).build();
    }

    @Test
    public void homePageTest() throws Exception{
        mockMvc.perform(get("/FrameData/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void getAllTest() throws Exception{
        List<CharacterFrameData> characterFrameData = new ArrayList<>();
        characterFrameData.add(new CharacterFrameData());
        characterFrameData.add(new CharacterFrameData());

        given(frameDataRetrievalService.findAll()).willReturn(characterFrameData);

        mockMvc.perform(get("/FrameData/all"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("frames", hasSize(2)))
                .andExpect(view().name("CharacterFrameData"));
    }

    @Test
    public void getCharacterSelect() throws Exception{
        mockMvc.perform(get("/FrameData/characterSelect"))
                .andExpect(status().isOk())
                .andExpect(view().name("CharacterSelect"));
    }

    @Test
    public void getCharacterFrameDataTest() throws Exception{
        List<CharacterFrameData> characterFrameData = new ArrayList<>();
        characterFrameData.add(new CharacterFrameData());
        characterFrameData.add(new CharacterFrameData());

        given(frameDataRetrievalService.getAllCharacterFrames("Akuma")).willReturn(characterFrameData);

        mockMvc.perform(get("/FrameData/Akuma"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("frames", hasSize(2)))
                .andExpect(view().name("CharacterFrameData"));
    }

    @Test
    public void getCharacterFrameDataTestError() throws Exception{
        List<CharacterFrameData> characterFrameData = new ArrayList<>();

        given(frameDataRetrievalService.getAllCharacterFrames("Akuma")).willReturn(characterFrameData);

        mockMvc.perform(get("/FrameData/Akuma"))
                .andExpect(status().isOk())
                .andExpect(view().name("ErrorPage"));
    }

    @Test
    public void getFrameTrapPageTest() throws Exception{
        mockMvc.perform(get("/FrameData/trap"))
                .andExpect(status().isOk())
                .andExpect(view().name("FrameTrapCharacterSelect"));
    }

    @Test
    public void getFrameTrapMoveSelectionTest() throws Exception{
        List<CharacterFrameData> characterFrameData = new ArrayList<>();
        characterFrameData.add(new CharacterFrameData());
        characterFrameData.add(new CharacterFrameData());

        given(frameDataRetrievalService.getAllCharacterFrames("Akuma")).willReturn(characterFrameData);

        mockMvc.perform(get("/FrameData/trap/Akuma"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("frames", hasSize(2)))
                .andExpect(view().name("FrameTrapMoveSelection"));
    }

    @Test
    public void getPunishmentToolTest() throws Exception{
        List<String> characters = new ArrayList<>();
        characters.add("Akuma");
        characters.add("Alisa");

        given(frameDataRetrievalService.getAllCharacters()).willReturn(characters);

        mockMvc.perform(get("/FrameData/block"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("characters", hasSize(2)))
                .andExpect(view().name("PunishmentTool"));
    }

    @Test
    public void getPunishmentToolMoveSelectionTest() throws Exception{
        List<CharacterFrameData> characterFrameData = new ArrayList<>();
        characterFrameData.add(new CharacterFrameData());
        characterFrameData.add(new CharacterFrameData());

        given(frameDataRetrievalService.getAllCharacterFrames("Alisa")).willReturn(characterFrameData);

        mockMvc.perform(get("/FrameData/block/Akuma/Alisa"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("character", "Akuma"))
                .andExpect(model().attribute("frames", hasSize(2)))
                .andExpect(view().name("PunishmentToolMoveSelection"));
    }

}
