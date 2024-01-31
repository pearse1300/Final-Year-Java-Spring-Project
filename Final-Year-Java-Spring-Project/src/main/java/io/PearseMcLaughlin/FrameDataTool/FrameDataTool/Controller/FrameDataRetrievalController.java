package io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Controller;

import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Entity.CharacterFrameData;
import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Repository.FrameDataRepository;
import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Services.FrameDataRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller //CHANGE BACK TO CONTROLLER
@RequestMapping("/FrameData")
public class FrameDataRetrievalController {

    @Autowired
    private FrameDataRetrievalService frameDataRetrievalService;
    private FrameDataRepository frameDataRepository;

    @RequestMapping(value= "/")
    public static String welcome(){
        return "index";
    }



    @RequestMapping(value = "/all", method=RequestMethod.GET)
    public String getDBFrameData(Model model){
        model.addAttribute("frames", frameDataRetrievalService.findAll());
        return "CharacterFrameData";
    }

    @RequestMapping(value="/characterSelect")
    public static String characterSelect(){
        return "CharacterSelect";
    }

    @RequestMapping(value="/{character}", method = RequestMethod.GET)
    public String getCharacterFrameData(@PathVariable("character") String character, Model model){
        List<CharacterFrameData> frames = frameDataRetrievalService.getAllCharacterFrames(character);
        if(frames.size() == 0 ){
            return "ErrorPage";
        }
        else {
            model.addAttribute("frames", frameDataRetrievalService.getAllCharacterFrames(character));
            return "CharacterFrameData";
        }
    }

    @RequestMapping(value = "/trap")
    public static String frameTrap(){return "FrameTrapCharacterSelect"; }

    @RequestMapping(value="trap/{character}", method=RequestMethod.GET)
    public String frametrap(@PathVariable String character, Model model){
        model.addAttribute("frames", frameDataRetrievalService.getAllCharacterFrames(character));
        return "FrameTrapMoveSelection";
    }

    @RequestMapping(value = "/block", method=RequestMethod.GET)
    public String blocked(Model model){
        model.addAttribute("characters", frameDataRetrievalService.getAllCharacters());
        return "PunishmentTool";
    }

    @RequestMapping(value="block/{character1}/{character2}", method=RequestMethod.GET)
    public String blocked(@PathVariable String character1, @PathVariable String character2, Model model){
        model.addAttribute("character", character1);
        model.addAttribute("frames", frameDataRetrievalService.getAllCharacterFrames(character2));
        return "PunishmentToolMoveSelection";
    }

}