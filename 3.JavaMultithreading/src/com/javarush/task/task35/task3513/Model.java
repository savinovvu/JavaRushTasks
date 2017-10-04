package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;


    public Model() {
        resetGameTiles();
    }

    public List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (Tile[] gameTile : gameTiles) {
            for (Tile tile : gameTile) {
                if (tile.isEmpty()) {
                    list.add(tile);
                }
            }
        }
        return list;
    }

    public void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        Tile tile = emptyTiles.get((int) (Math.random() * emptyTiles.size()));
        tile.value = (Math.random() < 0.9 ? 2 : 4);
    }

    public void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        score = 0;
        maxTile = 2;
        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChange = false;
        for (int i = 1; i < tiles.length; i++) {
            for (int j = 1; j < tiles.length; j++) {
                if (tiles[j - 1].isEmpty() && !tiles[j].isEmpty()) {
                    isChange = true;
                    tiles[j - 1] = tiles[j];
                    tiles[j] = new Tile();
                }
            }
        }
        return isChange;
    }


    private boolean mergeTiles(Tile[] tiles) {
        boolean isChange = false;
        for (int i = 1; i < tiles.length; i++) {
            if ((tiles[i - 1].value == tiles[i].value) && !tiles[i - 1].isEmpty() && !tiles[i].isEmpty()) {
                isChange = true;
                tiles[i - 1].value *= 2;
                score += tiles[i - 1].value;
                maxTile = maxTile > tiles[i - 1].value ? maxTile : tiles[i - 1].value;
                tiles[i] = new Tile();
                compressTiles(tiles);
            }
        }
        return isChange;
    }

    public void left() {
        boolean isChanged = false;
        for (Tile[] tiles : gameTiles) {
            if (compressTiles(tiles) | mergeTiles(tiles)) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
        }

    }


}
