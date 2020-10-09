package io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Entity;

import javax.persistence.*;

@Entity
@Table(name="character_frame_data")

public class CharacterFrameData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "character")
    private String character;
    @Column(name = "move_number")
    private Integer moveNumber;
    @Column(name = "command")
    private String command;
    @Column(name = "hit_level")
    private String hitLevel;
    @Column(name = "damage")
    private Integer damage;
    @Column(name = "start_up_frame")
    private Integer startUpFrame;
    @Column(name = "block_frame")
    private Integer blockFrame;
    @Column(name = "hit_frame")
    private Integer hitFrame;
    @Column(name = "hit_property")
    private String hitProperty;
    @Column(name = "counterhit_frame")
    private Integer counterHitFrame;
    @Column(name = "counterhit_property")
    private String counterHitProperty;
    @Column(name = "notes")
    private String notes;

    public CharacterFrameData(){

    }

    public CharacterFrameData(String character, Integer moveNumber, String command, String hitLevel, Integer damage, Integer startUpFrame, Integer blockFrame, Integer hitFrame, String hitProperty, Integer counterHitFrame, String counterHitProperty, String notes){
        this.character = character;
        this.moveNumber = moveNumber;
        this.command = command;
        this.hitLevel = hitLevel;
        this.damage = damage;
        this.startUpFrame = startUpFrame;
        this.blockFrame = blockFrame;
        this.hitFrame = hitFrame;
        this.hitProperty = hitProperty;
        this.counterHitFrame = counterHitFrame;
        this.counterHitProperty = counterHitProperty;
        this.notes = notes;
    }

    public CharacterFrameData(Integer id, String character, Integer moveNumber, String command, String hitLevel, Integer damage, Integer startUpFrame, Integer blockFrame, Integer hitFrame, String hitProperty, Integer counterHitFrame, String counterHitProperty, String notes){
        this.id = id;
        this.character = character;
        this.moveNumber = moveNumber;
        this.command = command;
        this.hitLevel = hitLevel;
        this.damage = damage;
        this.startUpFrame = startUpFrame;
        this.blockFrame = blockFrame;
        this.hitFrame = hitFrame;
        this.hitProperty = hitProperty;
        this.counterHitFrame = counterHitFrame;
        this.counterHitProperty = counterHitProperty;
        this.notes = notes;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setCharacter(String character){
        this.character = character;
    }

    public void setMoveNumber(Integer moveNumber) {
        this.moveNumber = moveNumber;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setHitLevel(String hitLevel) {
        this.hitLevel = hitLevel;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public void setStartUpFrame(Integer startUpFrame) {
        this.startUpFrame = startUpFrame;
    }

    public void setBlockFrame(Integer blockFrame) {
        this.blockFrame = blockFrame;
    }

    public void setHitFrame(Integer hitFrame) {
        this.hitFrame = hitFrame;
    }

    public void setHitProperty(String hitProperty) {
        this.hitProperty = hitProperty;
    }

    public void setCounterHitFrame(Integer counterHitFrame) {
        this.counterHitFrame = counterHitFrame;
    }

    public void setCounterHitProperty(String counterHitProperty) {
        this.counterHitProperty = counterHitProperty;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public String getCharacter() {
        return character;
    }

    public Integer getMoveNumber(){ return moveNumber; }

    public String getCommand() {
        return command;
    }

    public String getHitLevel() {
        return hitLevel;
    }

    public Integer getDamage() {
        return damage;
    }

    public Integer getStartUpFrame() {
        return startUpFrame;
    }

    public Integer getBlockFrame() {
        return blockFrame;
    }

    public Integer getHitFrame() {
        return hitFrame;
    }

    public String getHitProperty() {
        return hitProperty;
    }

    public Integer getCounterHitFrame() {
        return counterHitFrame;
    }

    public String getCounterHitProperty() {
        return counterHitProperty;
    }

    public String getNotes() {
        return notes;
    }
}


