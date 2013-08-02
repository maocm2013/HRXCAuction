重要说明：
运行ij.bat进行ij，进行命令交互
首次建立新库，并使用hrxc用户名：connect 'jdbc:derby://localhost:1527/data.db;user=hrxc;create=true';
建立连接：connect 'jdbc:derby://localhost:1527/data.db;user=hrxc';
服务启动后，如果通过网络无法联通derby数据库，则需要将start...Server.bat与stop...Server.bat中localhost修改为物理实际IP地址，然后再启动；