package io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Services;

import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Dao.FrameDataDao;
import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Entity.CharacterFrameData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FrameDataRetrievalService {

    @Autowired
    private FrameDataDao frameDataDao;

    public Collection<CharacterFrameData> getAllFrameData(){
        return this.frameDataDao.getAllFrameData();
    }

    public CharacterFrameData getMoveByMoveNumber(int moveNumber){
        return this.frameDataDao.getMoveByMoveNumber(moveNumber);
    }
}
