package io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Dao;

import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Entity.CharacterFrameData;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository ("FrameDataDao")
public class FrameDataDao {
    private static Map<Integer,CharacterFrameData> characterMoves;

//    static{
//        characterMoves = new HashMap<Integer, CharacterFrameData>(){
//            {
//                put(1, new CharacterFrameData(1,"command", "level", 6, 2, 3, 2, null, 4, null, null));
//                put(2, new CharacterFrameData(2,"DF2", "mid", 10, 15, -12, +3, "launch", +3, null, "Launcher"));
//
//            }
//            };
//        }
        public Collection<CharacterFrameData> getAllFrameData(){
            return this.characterMoves.values();
        }

        public CharacterFrameData getMoveByMoveNumber(int moveNumber){
            return this.characterMoves.get(moveNumber);
        }
    }
