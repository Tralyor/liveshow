package org.liveshow.entity.CombinationEntity;

/**
 * Created by Zzzz on 2017/12/1.
 */
public class AnchorInfo {

    private String userName;
    private String roomId;
    private String realName;
    private String cardId;
    private String telephone;
    private int highestPopulation;
    private int wholeDuration;
    private int times;
    private int danmakuNumber;

    public int getHighestPopulation() {
        return highestPopulation;
    }

    public void setHighestPopulation(int highestPopulation) {
        this.highestPopulation = highestPopulation;
    }

    public int getWholeDuration() {
        return wholeDuration;
    }

    public void setWholeDuration(int wholeDuration) {
        this.wholeDuration = wholeDuration;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getDanmakuNumber() {
        return danmakuNumber;
    }

    public void setDanmakuNumber(int danmakuNumber) {
        this.danmakuNumber = danmakuNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
