package models;

public class Line {
    private String building;
    private String space;
    private String name;
    private String placement;
    private String xOffset;
    private String yOffset;
    private String rotation;
    private String manufacturer;
    private String model;
    private String modelQualifier;
    private String rackStartUnit;
    private String unitsStartAtTo;

    public Line(String building, String space, String name, String placement, String xOffset, String yOffset, String rotation, String manufacturer, String model, String modelQualifier, String rackStartUnit, String unitsStartAtTo) {
        this.building = building;
        this.space = space;
        this.name = name;
        this.placement = placement;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.rotation = rotation;
        this.manufacturer = manufacturer;
        this.model = model;
        this.modelQualifier = modelQualifier;
        this.rackStartUnit = rackStartUnit;
        this.unitsStartAtTo = unitsStartAtTo;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String getxOffset() {
        return xOffset;
    }

    public void setxOffset(String xOffset) {
        this.xOffset = xOffset;
    }

    public String getyOffset() {
        return yOffset;
    }

    public void setyOffset(String yOffset) {
        this.yOffset = yOffset;
    }

    public String getRotation() {
        return rotation;
    }

    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelQualifier() {
        return modelQualifier;
    }

    public void setModelQualifier(String modelQualifier) {
        this.modelQualifier = modelQualifier;
    }

    public String getRackStartUnit() {
        return rackStartUnit;
    }

    public void setRackStartUnit(String rackStartUnit) {
        this.rackStartUnit = rackStartUnit;
    }

    public String getUnitsStartAtTo() {
        return unitsStartAtTo;
    }

    public void setUnitsStartAtTo(String unitsStartAtTo) {
        this.unitsStartAtTo = unitsStartAtTo;
    }

    @Override
    public String toString() {
        return "Line{" +
                "building='" + building + '\'' +
                ", space='" + space + '\'' +
                ", name='" + name + '\'' +
                ", placement='" + placement + '\'' +
                ", xOffset='" + xOffset + '\'' +
                ", yOffset='" + yOffset + '\'' +
                ", rotation='" + rotation + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", modelQualifier='" + modelQualifier + '\'' +
                ", rackStartUnit='" + rackStartUnit + '\'' +
                ", unitsStartAtTo='" + unitsStartAtTo + '\'' +
                '}';
    }
}
