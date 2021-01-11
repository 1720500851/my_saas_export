package cn.itcast.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author TongHu
 * @date 2021/1/10 - 21:11
 *
 *    日期类型转换器定义的步骤:
 *          1. 自定义类型实现Converter 接口
 *          2. 实现converter接口
 *          3. 创建日期类型转换器转换器对象
 *          4. 把日期类型转换器的对象交给转换器的工厂
 *          5. 类型转换器的工厂交给注解驱动去启动
 *
 */
@Component
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {  // 传递过来的时间1000-10-10
        try {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(source);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
