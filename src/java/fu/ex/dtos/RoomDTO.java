/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.ex.dtos;

/**
 *
 * @author DELL
 */
public class RoomDTO {

    private String id, name, building;
    private int floor;

    public RoomDTO() {
    }

    public RoomDTO(String id, String name, String building, int floor) {
        this.id = id;
        this.name = name;
        this.building = building;
        this.floor = floor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

}
