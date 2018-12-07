package com.wjdiankong.parsedex.struct;

import java.util.ArrayList;
import java.util.List;

/**
 *这里是不是弄错了？根据官方文档 https://source.android.com/devices/tech/dalvik/dex-format.html 中对 string_data_item 的描述
 *结构体应该如下：
 * 	/**
 * 	 * struct string_data_item
 *                {
 * 		uleb128 utf16_size; //以 UTF-16 代码单元（在许多系统中为“字符串长度”）为单位，用来描述字符串长度，一般来说不会超过两个字节，除非长度大于 2^7-1
 * 		ubyte[]  data;	    // MUTF-8 代码单元,后跟一个值为 0 的字节结束
 *        }
 *     */
*/

public class StringDataItem {

    /**
     * struct string_data_item
     {
     uleb128 utf16_size;
     ubyte data;
     }
     */

    /**
     * 上述描述里提到了 LEB128 （ little endian base 128 ) 格式 ，是基于 1 个 Byte 的一种不定长度的
     * 编码方式 。若第一个 Byte 的最高位为 1 ，则表示还需要下一个 Byte 来描述 ，直至最后一个 Byte 的最高
     * 位为 0 。每个 Byte 的其余 Bit 用来表示数据
     * 用来描述数据的长度
     */
    public List<Byte> utf16_size = new ArrayList<Byte>();
    /**
     * 数据的真实内容
     */
    public List<Byte> data= new ArrayList<Byte>();

}
