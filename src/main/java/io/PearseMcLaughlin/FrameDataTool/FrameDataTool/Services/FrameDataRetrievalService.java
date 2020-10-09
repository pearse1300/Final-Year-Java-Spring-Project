package io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Services;

import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Entity.CharacterFrameData;
import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Repository.FrameDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FrameDataRetrievalService {

    @Autowired
    private FrameDataRepository frameDataRepository;

    public List<CharacterFrameData> findAll() {
        return frameDataRepository.findAll();
    }

    public List<String> getAllCharacters() {
        List<CharacterFrameData> characterFrameData = frameDataRepository.findAll();
        List<String> characterNames = new ArrayList<String>();
        int i = 0;
        while(i < characterFrameData.size()){
            if(!characterNames.contains(characterFrameData.get(i).getCharacter())){
                characterNames.add(characterFrameData.get(i).getCharacter());
            }
            i++;
        }
        return characterNames;
    }

    public List<CharacterFrameData> getAllCharacterFrames(String character) {
        return frameDataRepository.findAllByCharacter(character);
    }

    public CharacterFrameData getAttackFrameData(int id){
        return frameDataRepository.findById(id);
    }
}
