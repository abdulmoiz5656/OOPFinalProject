import java.awt.Color;

public enum TileType {

    /**
     * Piece TypeI.
     */
    TypeI(new Color(BoardPanel.COLOR_MIN, BoardPanel.COLOR_MAX, BoardPanel.COLOR_MAX), 4, 4, 1, new boolean[][] {
            {
                    false,	false,	false,	false,
                    true,	true,	true,	true,
                    false,	false,	false,	false,
                    false,	false,	false,	false,
            },
            {
                    false,	false,	true,	false,
                    false,	false,	true,	false,
                    false,	false,	true,	false,
                    false,	false,	true,	false,
            },
            {
                    false,	false,	false,	false,
                    false,	false,	false,	false,
                    true,	true,	true,	true,
                    false,	false,	false,	false,
            },
            {
                    false,	true,	false,	false,
                    false,	true,	false,	false,
                    false,	true,	false,	false,
                    false,	true,	false,	false,
            }
    }),

    /**
     * Piece TypeJ.
     */
    TypeJ(new Color(BoardPanel.COLOR_MIN, BoardPanel.COLOR_MIN, BoardPanel.COLOR_MAX), 3, 3, 2, new boolean[][] {
            {
                    true,	false,	false,
                    true,	true,	true,
                    false,	false,	false,
            },
            {
                    false,	true,	true,
                    false,	true,	false,
                    false,	true,	false,
            },
            {
                    false,	false,	false,
                    true,	true,	true,
                    false,	false,	true,
            },
            {
                    false,	true,	false,
                    false,	true,	false,
                    true,	true,	false,
            }
    }),

    /**
     * Piece TypeL.
     */
    TypeL(new Color(BoardPanel.COLOR_MAX, 127, BoardPanel.COLOR_MIN), 3, 3, 2, new boolean[][] {
            {
                    false,	false,	true,
                    true,	true,	true,
                    false,	false,	false,
            },
            {
                    false,	true,	false,
                    false,	true,	false,
                    false,	true,	true,
            },
            {
                    false,	false,	false,
                    true,	true,	true,
                    true,	false,	false,
            },
            {
                    true,	true,	false,
                    false,	true,	false,
                    false,	true,	false,
            }
    }),

    /**
     * Piece TypeO.
     */
    TypeO(new Color(BoardPanel.COLOR_MAX, BoardPanel.COLOR_MAX, BoardPanel.COLOR_MIN), 2, 2, 2, new boolean[][] {
            {
                    true,	true,
                    true,	true,
            },
            {
                    true,	true,
                    true,	true,
            },
            {
                    true,	true,
                    true,	true,
            },
            {
                    true,	true,
                    true,	true,
            }
    }),

    /**
     * Piece TypeS.
     */
    TypeS(new Color(BoardPanel.COLOR_MIN, BoardPanel.COLOR_MAX, BoardPanel.COLOR_MIN), 3, 3, 2, new boolean[][] {
            {
                    false,	true,	true,
                    true,	true,	false,
                    false,	false,	false,
            },
            {
                    false,	true,	false,
                    false,	true,	true,
                    false,	false,	true,
            },
            {
                    false,	false,	false,
                    false,	true,	true,
                    true,	true,	false,
            },
            {
                    true,	false,	false,
                    true,	true,	false,
                    false,	true,	false,
            }
    }),

    /**
     * Piece TypeT.
     */
    TypeT(new Color(128, BoardPanel.COLOR_MIN, 128), 3, 3, 2, new boolean[][] {
            {
                    false,	true,	false,
                    true,	true,	true,
                    false,	false,	false,
            },
            {
                    false,	true,	false,
                    false,	true,	true,
                    false,	true,	false,
            },
            {
                    false,	false,	false,
                    true,	true,	true,
                    false,	true,	false,
            },
            {
                    false,	true,	false,
                    true,	true,	false,
                    false,	true,	false,
            }
    }),

    /**
     * Piece TypeZ.
     */
    TypeZ(new Color(BoardPanel.COLOR_MAX, BoardPanel.COLOR_MIN, BoardPanel.COLOR_MIN), 3, 3, 2, new boolean[][] {
            {
                    true,	true,	false,
                    false,	true,	true,
                    false,	false,	false,
            },
            {
                    false,	false,	true,
                    false,	true,	true,
                    false,	true,	false,
            },
            {
                    false,	false,	false,
                    true,	true,	false,
                    false,	true,	true,
            },
            {
                    false,	true,	false,
                    true,	true,	false,
                    true,	false,	false,
            }
    });

    /**
     * The base color of tiles of this type.
     */
    private Color baseColor;

    /**
     * The light shading color of tiles of this type.
     */
    private Color lightColor;

    /**
     * The dark shading color of tiles of this type.
     */
    private Color darkColor;

    /**
     * The column that this type spawns in.
     */
    private int spawnCol;

    /**
     * The row that this type spawns in.
     */
    private int spawnRow;

    /**
     * The dimensions of the array for this piece.
     */
    private int dimension;

    /**
     * The number of rows in this piece. (Only valid when rotation is 0 or 2,
     * but it's fine since we're only using it for displaying the next piece
     * preview, which uses rotation 0).
     */
    private int rows;

    /**
     * The number of columns in this piece. (Only valid when rotation is 0 or 2,
     * but it's fine since we're only using it for displaying the next piece
     * preview, which uses rotation 0).
     */
    private int cols;

    /**
     * The tiles for this piece. Each piece has an array of tiles for each rotation.
     */
    private boolean[][] tiles;


        TileType(Color color, int dimension, int cols, int rows, boolean[][] tiles) {
        this.baseColor = color;
        this.lightColor = color.brighter();
        this.darkColor = color.darker();
        this.dimension = dimension;
        this.tiles = tiles;
        this.cols = cols;
        this.rows = rows;

        this.spawnCol = 5 - (dimension >> 1);
        this.spawnRow = getTopInset(0);
    }

    public Color getBaseColor() {
        return baseColor;
    }

    public Color getLightColor() {
        return lightColor;
    }

    public Color getDarkColor() {
        return darkColor;
    }

    public int getDimension() {
        return dimension;
    }

    public int getSpawnColumn() {
        return spawnCol;
    }

    public int getSpawnRow() {
        return spawnRow;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public boolean isTile(int x, int y, int rotation) {
        return tiles[rotation][y * dimension + x];
    }

    public int getLeftInset(int rotation) {
        /*
         * Loop through from left to right until we find a tile then return
         * the column.
         */
        for(int x = 0; x < dimension; x++) {
            for(int y = 0; y < dimension; y++) {
                if(isTile(x, y, rotation)) {
                    return x;
                }
            }
        }
        return -1;
    }

    public int getRightInset(int rotation) {
        /*
         * Loop through from right to left until we find a tile then return
         * the column.
         */
        for(int x = dimension - 1; x >= 0; x--) {
            for(int y = 0; y < dimension; y++) {
                if(isTile(x, y, rotation)) {
                    return dimension - x;
                }
            }
        }
        return -1;
    }

    public int getTopInset(int rotation) {
        /*
         * Loop through from top to bottom until we find a tile then return
         * the row.
         */
        for(int y = 0; y < dimension; y++) {
            for(int x = 0; x < dimension; x++) {
                if(isTile(x, y, rotation)) {
                    return y;
                }
            }
        }
        return -1;
    }

    public int getBottomInset(int rotation) {
        /*
         * Loop through from bottom to top until we find a tile then return
         * the row.
         */
        for(int y = dimension - 1; y >= 0; y--) {
            for(int x = 0; x < dimension; x++) {
                if(isTile(x, y, rotation)) {
                    return dimension - y;
                }
            }
        }
        return -1;
    }

}