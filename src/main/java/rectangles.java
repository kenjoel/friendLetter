import java.util.ArrayList;

public class rectangles {
    public static class Rectangle {
        private int height;
        private int width;
        private static ArrayList<Rectangle> mInstances = new ArrayList<>();
        private Boolean shape;

        public Rectangle(int height, int width) {
            this.height = height;
            this.width = width;
            this.shape = isRectSquare();
            this.mInstances.add(this);
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }
        public static ArrayList<Rectangle> getAll() {
            return mInstances;
        }

        public boolean getShape(){
            return shape;
        }

        boolean isRectSquare(){
            return height == width;
        }

    }
}
