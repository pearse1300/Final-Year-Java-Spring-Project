package io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Controller;

import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Entity.CharacterFrameData;
import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Repository.FrameDataRepository;
import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Services.FrameDataRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.List;

//TODO add these to service layer, fix errors, add error handling for attacks that knockdown on hit.
@Controller
@RequestMapping("/FrameDataCalculate")
public class FrameDataCalculationController {

    @Autowired
    private FrameDataRetrievalService frameDataRetrievalService;
    private FrameDataRepository frameDataRepository;


    @RequestMapping(value = "/blocked/{id}/{character}", method = RequestMethod.GET)
    public String getPunishment(@PathVariable int id, @PathVariable String character, Model model){
        CharacterFrameData atk = frameDataRetrievalService.getAttackFrameData(id);
        int attack = atk.getBlockFrame();
        List<CharacterFrameData> characterFrameData = frameDataRetrievalService.getAllCharacterFrames(character);
        List<CharacterFrameData> punishMoves = new ArrayList<CharacterFrameData>();
       int i = 0;
       if (attack >= -9)
       {
           return "ErrorPunishmentPage";
       }
       else {
           while (i < characterFrameData.size()) {
               if (characterFrameData.get(i).getStartUpFrame() <= (-1 * attack)) {
                   punishMoves.add(characterFrameData.get(i));
               }
               i++;
           }
           model.addAttribute("frames", punishMoves);
           return "CharacterFrameData";
       }
    }

    @RequestMapping(value = "/Trap/{id}/{character}", method = RequestMethod.GET)
    public String getFrameTrap(@PathVariable int id, @PathVariable String character, Model model){
        CharacterFrameData atk = frameDataRetrievalService.getAttackFrameData(id);
        List<CharacterFrameData> characterFrameData = frameDataRetrievalService.getAllCharacterFrames(character);

        //return frameDataCalculateService.getFrameTrap(characterFrameData, atk);
        List<CharacterFrameData> punishMoves = new ArrayList<CharacterFrameData>();
        int i = 0;
        if (atk.getHitFrame() == null || atk.getHitFrame() <= 0){
            return "ErrorTrapPage"; //return error page for invalid move.

        }
        else {
            int attack = atk.getHitFrame();

            while (i < characterFrameData.size()) {
                if (characterFrameData.get(i).getStartUpFrame() - attack <= 10)
                {
                    punishMoves.add(characterFrameData.get(i));
                }
                i++;
            }
        }
        model.addAttribute("frames", punishMoves);
        return "CharacterFrameData";
    }
}