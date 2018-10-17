#!/bin/bash
function startTomcat(){
	sh /alidata/server/tomcat8/bin/startup.sh
	echo "启动 Tomcat 完成"
}

function shutdownTomcat(){
	sh /alidata/server/tomcat8/bin/shutdown.sh
	echo "关闭 Tomcat 完成"
}

function restartTomcat(){
	shutdownTomcat
	startTomcat
	echo "重启 Tomcat 完成"
}

function startResin(){
	sh /alidata/server/resin4/bin/resin.sh start
	echo "启动 Resin 完成"
}

function shutdownResin(){
	sh /alidata/server/resin4/bin/resin.sh shutdown
	echo "关闭 Resin 完成"
}

function restartResin(){
	sh /alidata/server/resin4/bin/resin.sh shutdown
	sh /alidata/server/resin4/bin/resin.sh start
	echo "重启 Resin 完成"
}

function startNginx(){
	/usr/local/nginx/sbin/nginx
	echo "启动 Nginx 完成"
}

function stopNginx(){
	/usr/local/nginx/sbin/nginx -s stop
	echo "关闭 Nginx 完成"
}

function reloadNginx(){
	/usr/local/nginx/sbin/nginx -s reload
	echo "重新加载 Nginx 完成"
}

function restartNginx(){
	stopNginx
	startNginx
	echo "重启 Nginx 完成"
}

function validateNginxConf(){
	/usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf
	echo "校验 Nginx 配置文件完成"
}

if [ -z $1 ];then
	echo "参数错误，请输入参数"
	echo "参数列表"
	echo "startTomcat"
	echo "shutdownTomcat"
	echo "restartTomcat"
	echo "startResin"
	echo "shutdownResin"
	echo "restartResin"
	echo "startNginx"
	echo "stopNginx"
	echo "restartNginx"
	echo "reloadNginx"
	echo "validateNginxConf"
	exit 2
else
	echo "参数为 $1"
		case $1 in
		"startTomcat")
			startTomcat ;;
		"shutdownTomcat")
			shutdownTomcat ;;
		"restartTomcat")
			restartTomcat ;;
		"startResin")
			startResin ;;
		"shutdownResin")
			shutdownResin ;;
		"restartTomcat")
			restartTomcat ;;
		"startNginxa")
			startNginx ;;
		"stopNginx")
			stopNginx ;;
		"restartNginx")
			restartNginx ;;
		"reloadNginx")
			reloadNginx ;;
		"validateNginxConf")
			validateNginxConf ;;
	esac
	exit 0
fi





