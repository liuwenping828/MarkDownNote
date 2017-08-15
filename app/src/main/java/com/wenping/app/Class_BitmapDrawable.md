# BitmapDrawable Class
### 描述
一个包裹 Bitmap 的 Drawable 类，可以用来平铺，拉伸，对齐操作
### 构造方法
1.BitmapDrawable(Resources res, Bitmap bitmap)
2.BitmapDrawable(Resources res, String filepath)
3.BitmapDrawable(Resources res, InputStream is)

注意: 其他构造方法已过时

### Public 方法
1.getBitmap() 返回此drawable用于渲染的位图,可能为null

2.getIntrinsicHeight() 返回drawable的内在高度

3.getIntrinsicWidth()  返回drawable的内在宽度

4.getOpacity() 返回此Drawable的不透明度/透明度(即  PixelFormat: UNKNOWN, TRANSLUCENT, TRANSPARENT, or OPAQUE)

5.setAlpha(int alpha)  设置透明度（取值范围0--255）

6.setAntiAlias(boolean aa)  设置是否抗锯齿

7.setColorFilter(ColorFilter colorFilter) 设置颜色过滤器





