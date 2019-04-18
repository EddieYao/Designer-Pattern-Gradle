package strategy.wechatShare;

/**
 * 界面
 */
public class ViewResult {
    public static void main(String[] args) {
        final int wechatType = 1;
        try {
            if (wechatType == 1){
                Context context = new Context(new WechatShareTitle(),new QQShareImg());
                context.getShareImg();
                context.getShareTitle();
            }
        } catch (Exception e) {
            System.out.println("错误信息: " + e.getMessage());
        }
    }
}
