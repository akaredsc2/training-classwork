package org.vitaly.week03.lesson08.builder;

/**
 * Created by vitaly on 15.02.17.
 */

abstract class Building {
    String base;
    String roof;
    String wall;

    public abstract void setBase(String base);

    public abstract void setRoof(String roof);

    public abstract void setWall(String wall);
}

class Cottege extends Building {
    @Override
    public void setBase(String base) {
        this.base = base;
    }

    @Override
    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public void setWall(String wall) {
        this.wall = wall;
    }
}

class Skyscraper extends Building {
    @Override
    public void setBase(String base) {
        this.base = base;
    }

    @Override
    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public void setWall(String wall) {
        this.wall = wall;
    }
}

abstract class Builder {
    Building building;

    public Building getBuilding() {
        return building;
    }

    public abstract void buildBase();

    public abstract void buildRoof();

    public abstract void buildWall();
}

class CottageBuilder extends Builder {
    public CottageBuilder() {
        building = new Cottege();
    }

    @Override
    public void buildBase() {
        building.setBase("cottage base");
    }

    @Override
    public void buildRoof() {
        building.setBase("cottage roof");
    }

    @Override
    public void buildWall() {
        building.setWall("cottage wall");
    }
}

class SkyscraperBuilder extends Builder {

    public SkyscraperBuilder() {
        building = new Skyscraper();
    }

    @Override
    public void buildBase() {
        building.setBase("skyscraper base");
    }

    @Override
    public void buildRoof() {
        building.setBase("skyscraper roof");
    }

    @Override
    public void buildWall() {
        building.setWall("skyscraper wall");
    }
}

class Foreman {
    Builder builder;

    public Foreman(Builder builder) {
        this.builder = builder;
    }

    public void createBuilding() {
        builder.buildBase();
        builder.buildRoof();
        builder.buildWall();
    }
}

public class Main {
    public static void main(String[] args) {
        Builder builder = new CottageBuilder();
        Foreman foreman = new Foreman(builder);
        foreman.createBuilding();
        Building building = builder.getBuilding();
    }
}
