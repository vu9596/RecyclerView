package vunt.com.vn.recyclerview;

public class Hero {
    private String mName;
    private int mResourceImage;

    public Hero(String name, int resourceImage) {
        mName = name;
        mResourceImage = resourceImage;
    }

    public String getName() {
        return mName;
    }

    public Hero setName(String name) {
        mName = name;
        return this;
    }

    public int getResourceImage() {
        return mResourceImage;
    }

    public Hero setResourceImage(int resourceImage) {
        mResourceImage = resourceImage;
        return this;
    }
}

