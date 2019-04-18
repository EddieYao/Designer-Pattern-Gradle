package strategy.wechatShare;
//具体的策略类
public class QQShareImg implements ShareImg {
    @Override
    public void shareImg() {
        System.out.println("this is the QQShareImg");
    }
}
