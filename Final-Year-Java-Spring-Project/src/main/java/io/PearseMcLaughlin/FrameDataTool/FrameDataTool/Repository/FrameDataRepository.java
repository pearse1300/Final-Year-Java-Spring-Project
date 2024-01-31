package io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Repository;

import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Entity.CharacterFrameData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrameDataRepository extends JpaRepository<CharacterFrameData, Integer> {

    public List<CharacterFrameData> findAllByCharacter (String character);
    public CharacterFrameData findById(int id);
}
