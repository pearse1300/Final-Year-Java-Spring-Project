package io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Controller;

import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Entity.CharacterFrameData;
import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Repository.FrameDataRepository;
import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Services.FrameDataRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/FrameData")
public class FrameDataCalculateController {

    @Autowired
    private FrameDataRetrievalService frameDataRetrievalService;
    private FrameDataRepository frameDataRepository;

//    @RequestMapping(method = RequestMethod.GET)
//    public Collection<CharacterFrameData> getAllFrameData(){
//        return frameDataRetrievalService.getAllFrameData();
//    }
//
//    @RequestMapping(value = "/{moveNumber}", method = RequestMethod.GET)
//    public CharacterFrameData getMoveByMoveNumber(@PathVariable("moveNumber") int moveNumber){
//        return frameDataRetrievalService.getMoveByMoveNumber(moveNumber);
//    }

    @GetMapping(value = "/all")
    public List<CharacterFrameData> getDBFrameData(){
        return frameDataRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<CharacterFrameData> persist(@RequestBody final CharacterFrameData characterFrameData){
        frameDataRepository.save(characterFrameData);
        return frameDataRepository.findAll();
    }

}
