package strategy.wechatShare;
//策略类实现
//每种分享方式为一种策略(分享标题，照片等)
public class Context {
    private ShareTitle shareTitle;
    private ShareImg shareImg;

    public Context(ShareTitle shareTitle, ShareImg shareImg) {
        this.shareTitle = shareTitle;
        this.shareImg = shareImg;
    }

    void getShareTitle (){
        shareTitle.showTitle();
    }
    void getShareImg (){
        shareImg.shareImg();
    }
}
