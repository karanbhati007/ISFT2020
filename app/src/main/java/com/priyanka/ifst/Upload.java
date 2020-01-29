package com.priyanka.ifst;

public class Upload {
    private String mImageUrl;
    public Upload()
    {
        // empty Constructor needed
    };
    public Upload(String mImageUrl)
    {
        this.mImageUrl=mImageUrl;
    }
    public String getUrl()
    {
        return mImageUrl;
    }
    public void setUrl(String mImageUrl)
    {
        this.mImageUrl=mImageUrl;
    }
}
