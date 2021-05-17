import java.time.ZonedDateTime;

public class GetTime
{
    public static void main(String[] args)
    {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);

       //2021-05-17T08:49:58.401+08:00[Asia/Shanghai]
    }
}
