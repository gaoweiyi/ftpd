# ftpd
一个优雅的在线下载服务器上的内容的web应用，使用java开发
可以展示服务器中某个目录下的文件列表（类似于虚拟主机的那种，但界面更友好）。点击文件可以下载，可以复制文件地址用于分享该文件。可以快速的搜索文件。
<br><br>
效果展示网站：<br>
<a href='http://ftpd.inputabc.com'>ftpd.inputabc.com</a>
<br><br>
使用说明：<br>
直接将war文件放到tomcat服务器里运行。<br>
如果无法运行，可能你的服务器没有安装jdk。<br>
#### ftpd的全局首选项在config.properties文件中，需要对网站进行自定义配置请查看并修改这个文件
用之前请先修改WEB-INF/classes/config/config.properties里的basePath属性，修改为你自己要展示文件列表的根目录，必须为绝对路径<br>
如果你的basePath里的文件比较少，建议将索引更新频率设的高一点，不然可能前几次访问该网站无法搜索文件。例如改为每20秒更新一次，可以设为0/20 * * * * ?，在spring目录下的applicationContext-quartz.xml里设置<br>
<br>
更新日志：<br>
v2.2.1<br>
改进了搜索功能的体验<br>
将请求安全策略改为可选项，可以在config.properties里配置
<br>
v2.2.0<br>
添加了文件搜索功能<br>
修复了一些bug<br>
增加了防恶意攻击措施<br>
v2.1.0<br>
优化了性能<br>
v2.0.0<br>
细节优化；BUG修复
