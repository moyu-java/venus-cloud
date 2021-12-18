package com.junmoyu.venus.cloud.starter.core.model.dto;

/**
 * 接口返回状态码
 * <p>
 * 状态码共 5 位，错误码命名规则：错误产生来源 + 四位数字编号
 * <p>
 * 错误产生来源：
 * A0000 : 错误来源于用户
 * B0000 : 错误来源于当前系统
 * C0000 : 错误来源于第三方，如 CDN、RPC
 * <p>
 * 四位数字编号从 0001 到 9999，大类之间的步长间距预留 100
 * <p>
 * 编号确定之后，永久固定，不得修改。
 *
 * @author moyu.jun
 * @date 2021/12/18
 */
public enum ResponseCode {

    /**
     * 成功返回，一切 OK
     */
    SUCCESS("00000", "操作成功"),

    /**
     * 一级宏观错误码
     * 客户端错误
     */
    CLIENT("A0001", "客户端错误"),

    /**
     * 一级宏观错误码
     * 系统执行出错
     */
    SYSTEM("B0001", "系统异常"),

    /**
     * 一级宏观错误码
     * 调用第三方服务出错
     */
    THIRD("C0001", "调用第三方服务出错"),

    /**
     * 二级宏观错误码
     * 客户端请求参数异常（A0100 - A0199）
     */
    CLIENT_PARAM("A0100", "请求参数异常"),
    CLIENT_PARAM_REQUIRED_IS_NULL("A0101", "请求必填参数为空"),
    CLIENT_PARAM_INPUT_INVALID("A0102", "无效的用户输入"),
    CLIENT_PARAM_FORMAT_INVALID("A0103", "参数格式不匹配"),
    CLIENT_PARAM_JSON_PARSE_FAILED("A0104", "请求 JSON 解析失败"),
    CLIENT_PARAM_INCLUDE_ILLEGAL_WORDS("A0105", "包含违禁敏感词"),
    CLIENT_PARAM_VALUE_OUT_RANGE("A0106", "请求参数值超出允许的范围"),
    CLIENT_PARAM_DATA_NOT_EXIST("A0107", "请求数据不存在"),
    CLIENT_PARAM_ILLEGAL("A0108", "非法的请求参数"),

    CLIENT_PARAM_REG_NAME_INVALID("A0110", "用户名不合法"),
    CLIENT_PARAM_REG_NAME_EXIST("A0111", "用户名已存在"),
    CLIENT_PARAM_REG_NAME_SENSITIVE("A0112", "用户名包含敏感词"),
    CLIENT_PARAM_REG_NAME_SPECIAL("A0113", "用户名包含特殊字符"),

    CLIENT_PARAM_PASSWORD_INVALID("A0120", "密码校验失败"),
    CLIENT_PARAM_PASSWORD_SHORT("A0121", "密码长度不够"),
    CLIENT_PARAM_PASSWORD_WEAK("A0122", "密码强度不够"),

    CLIENT_PARAM_CODE_INVALID("A0130", "校验码输入错误"),
    CLIENT_PARAM_SMS_CODE_INVALID("A0131", "短信校验码输入错误"),
    CLIENT_PARAM_MAIL_CODE_INVALID("A0132", "邮件校验码输入错误"),
    CLIENT_PARAM_VOICE_CODE_INVALID("A0133", "语音校验码输入错误"),

    CLIENT_PARAM_CERT_INVALID("A0140", "用户证件异常"),
    CLIENT_PARAM_CERT_TYPE_NOT_CHOOSE("A0141", "用户证件类型未选择"),
    CLIENT_PARAM_ID_CARD_INVALID("A0142", "大陆身份证编号校验非法"),
    CLIENT_PARAM_PASSPORT_INVALID("A0143", "护照编号校验非法"),

    CLIENT_PARAM_BASE_INFO_INVALID("A0150", "用户基本信息校验失败"),
    CLIENT_PARAM_ADDRESS_INVALID("A0151", "地址格式校验失败"),

    CLIENT_PARAM_MOBILE_INVALID("A0160", "该手机号码格式不正确"),
    CLIENT_PARAM_MOBILE_BOUND("A0161", "该手机号码已被绑定"),
    CLIENT_PARAM_MOBILE_REGISTERED("A0162", "该手机号码已注册"),

    CLIENT_PARAM_EMAIL_INVALID("A0170", "该邮箱格式不正确"),
    CLIENT_PARAM_EMAIL_BOUND("A0171", "该邮箱已被绑定"),
    CLIENT_PARAM_EMAIL_REGISTERED("A0172", "该邮箱已注册"),

    /**
     * 二级宏观错误码
     * 操作异常（A0200 - A0299）
     */
    CLIENT_OPERATE("A0200", "操作异常"),
    CLIENT_OPERATE_DATA_EXIST("A0201", "数据已存在"),
    CLIENT_OPERATE_DATA_NOT_EXIST("A0202", "数据不存在"),

    /**
     * 二级宏观错误码
     * 认证授权异常（A0300 - A0399）
     */
    CLIENT_AUTH("A0300", "认证授权异常"),
    CLIENT_AUTH_ACCESS_DENIED("A0301", "访问未授权"),
    CLIENT_AUTH_AUTHORIZING("A0302", "正在授权中"),
    CLIENT_AUTH_REJECTED("A0303", "用户授权申请被拒绝"),
    CLIENT_AUTH_EXPIRED("A0304", "授权已过期"),
    CLIENT_AUTH_NO_PERMISSION("A0305", "权限不足"),
    CLIENT_AUTH_REQUEST_INTERCEPTED("A0306", "用户访问被拦截"),
    CLIENT_AUTH_BLACKLIST("A0307", "黑名单用户"),
    CLIENT_AUTH_ACCOUNT_LOCKED("A0308", "账号被冻结"),
    CLIENT_AUTH_IP_INVALID("A0309", "非法 IP 地址"),
    CLIENT_AUTH_GATEWAY_ACCESS_DENIED("A0310", "网关访问受限"),
    CLIENT_AUTH_REGION_BLACKLIST("A0311", "地域黑名单"),
    CLIENT_AUTH_SERVICE_OVERDUE("A0312", "服务已欠费"),
    CLIENT_AUTH_SIGNATURE_INVALID("A0313", "用户签名异常"),
    CLIENT_AUTH_RSA_SIGNATURE_ERROR("A0314", "RSA 签名错误"),
    CLIENT_AUTH_CLIENT_INVALID("A0315", "无效的客户端"),
    CLIENT_AUTH_CLIENT_UNAUTHORIZED("A0316", "未经授权的客户端"),
    CLIENT_AUTH_GRANT_INVALID("A0317", "认证失败"),
    CLIENT_AUTH_SCOPE_INVALID("A0318", "无效的认证范围"),
    CLIENT_AUTH_TOKEN_INVALID("A0319", "无效的 token"),
    CLIENT_AUTH_REQUEST_INVALID("A0320", "无效的请求"),
    CLIENT_AUTH_REDIRECT_MISMATCH("A0321", "重定向 URL 不匹配"),
    CLIENT_AUTH_GRANT_TYPE_UNSUPPORTED("A0322", "不支持的认证类型"),
    CLIENT_AUTH_RESPONSE_TYPE_UNSUPPORTED("A0323", "不支持的响应类型"),
    CLIENT_AUTH_INTERCEPTED_FOR_PRIVACY("A0324", "因访问对象隐私设置被拦截"),

    /**
     * 二级宏观错误码
     * 用户角色权限异常（A0400 - A0499）
     */
    CLIENT_UIMS("A0400", "用户权限异常"),
    CLIENT_UIMS_USER_EXIST("A0401", "用户已存在"),
    CLIENT_UIMS_USER_NOT_EXIST("A0402", "用户不存在"),
    CLIENT_UIMS_ROLE_EXIST("A0403", "角色已存在"),
    CLIENT_UIMS_ROLE_NOT_EXIST("A0404", "角色不存在"),
    CLIENT_UIMS_PERMISSION_EXIST("A0405", "权限已存在"),
    CLIENT_UIMS_PERMISSION_NOT_EXIST("A0406", "权限不存在"),
    CLIENT_UIMS_ACCOUNT_LOCKED("A0407", "用户账户被冻结"),
    CLIENT_UIMS_ACCOUNT_CANCELED("A0408", "用户账户已作废"),
    CLIENT_UIMS_USER_DELETED("A0409", "用户被删除，用户名不能重复"),
    CLIENT_UIMS_ROLE_DELETED("A0410", "角色被删除，角色名不能重复"),
    CLIENT_UIMS_ACCOUNT_INVALID("A0411", "用户账号格式错误"),
    CLIENT_UIMS_ROLE_CODE_EXIST("A0412", "角色编码已存在"),

    CLIENT_UIMS_PASSWORD_INVALID("A0420", "用户名或密码错误"),
    CLIENT_UIMS_PASSWORD_COUNT_EXCEED("A0421", "用户输入密码次数超限"),
    CLIENT_UIMS_ROLE_INVALID("A0422", "用户身份校验失败"),
    CLIENT_UIMS_THIRD_AUTH_INVALID("A0423", "用户未获得第三方登录授权"),
    CLIENT_UIMS_EXPIRED("A0430", "用户登录已过期"),
    CLIENT_UIMS_VALIDATE_CODE_INVALID("A0440", "验证码错误或已过期"),
    CLIENT_UIMS_VALIDATE_CODE_EXCEED("A0441", "用户验证码尝试次数超限"),

    CLIENT_UIMS_REG("A0450", "用户注册错误"),
    CLIENT_UIMS_REG_NO_AGREE_PRIVACY("A0451", "用户未同意隐私协议"),
    CLIENT_UIMS_REG_AREA_LIMIT("A0452", "注册国家或地区受限"),


    /**
     * 客户端 - 产品服务异常
     */
    CLIENT_PRODUCT_EXISTS("A0501", "产品已存在"),
    CLIENT_PRODUCT_NOT_EXISTS("A0502", "产品不存在"),
    CLIENT_PRODUCT_CODE_EXISTS("A0503", "产品编码已存在"),
    CLIENT_PRODUCT_DELETED("A0504", "产品被删除"),

    /**
     * 二级宏观错误码
     * 用户资源异常
     */
    CLIENT_RESOURCE("A0600", "用户资源异常"),
    CLIENT_RESOURCE_ACCOUNT_BALANCE_OVER("A0601", "账户余额不足"),
    CLIENT_RESOURCE_DISK_SPACE_OVER("A0602", "用户磁盘空间不足"),
    CLIENT_RESOURCE_MEMORY_SPACE_OVER("A0603", "用户内存空间不足"),
    CLIENT_RESOURCE_OSS_SPACE_OVER("A0604", "用户 OSS 容量不足"),
    // 例如：每天抽奖数
    CLIENT_RESOURCE_USER_QUOTA_OVER("A0605", "用户配额已用光"),
    /**
     * 二级宏观错误码
     * 用户上传文件异常
     */
    CLIENT_UPLOAD("A0700", "用户上传文件异常"),
    CLIENT_UPLOAD_FILE_TYPE_MISMATCH("A0701", "用户上传文件类型不匹配"),
    CLIENT_UPLOAD_FILE_TOO_LARGE("A0702", "用户上传文件太大"),
    CLIENT_UPLOAD_IMAGE_TOO_LARGE("A0703", "用户上传图片太大"),
    CLIENT_UPLOAD_VIDEO_TOO_LAGER("A0704", "用户上传视频太大"),
    CLIENT_UPLOAD_ZIP_FILE_TOO_LARGE("A0705", "用户上传压缩文件太大"),
    /**
     * 二级宏观错误码
     * 用户当前版本异常
     */
    CLIENT_VERSION("A0800", "用户当前版本异常"),
    CLIENT_VERSION_SYSTEM_MISMATCH("A0801", "用户安装版本与系统不匹配"),
    CLIENT_VERSION_TOO_LOW("A0802", "用户安装版本过低"),
    CLIENT_VERSION_TOO_HIGH("A0803", "用户安装版本过高"),
    CLIENT_VERSION_EXPIRED("A0804", "用户安装版本已过期"),
    CLIENT_VERSION_API_MISMATCH("A0805", "用户 API 请求版本不匹配"),
    CLIENT_VERSION_API_TOO_HIGH("A0806", "用户 API 请求版本过高"),
    CLIENT_VERSION_API_TOO_LOW("A0807", "用户 API 请求版本过低"),
    /**
     * 二级宏观错误码
     * 用户隐私未授权
     */
    CLIENT_PERMISSION("A0900", "用户隐私未授权"),
    CLIENT_PERMISSION_NOT_CONFIRM("A0901", "用户隐私未签署"),
    CLIENT_PERMISSION_NO_CAMERA("A0902", "用户摄像头未授权"),
    CLIENT_PERMISSION_NO_CAMERA_SOFT("A0903", "用户相机未授权"),
    CLIENT_PERMISSION_NO_PICTURE_LIB("A0904", "用户图片库未授权"),
    CLIENT_PERMISSION_NO_FILE("A0905", "用户文件未授权"),
    CLIENT_PERMISSION_NO_LOCATION("A0906", "用户位置信息未授权"),
    CLIENT_PERMISSION_NO_MAIL_LIST("A0907", "用户通讯录未授权"),
    /**
     * 二级宏观错误码
     * 用户设备异常
     */
    CLIENT_DEVICE("A1000", "用户设备异常"),
    CLIENT_DEVICE_CAMERA("A1001", "用户相机异常"),
    CLIENT_DEVICE_MICROPHONE("A1002", "用户麦克风异常"),
    CLIENT_DEVICE_RECEIVER("A1003", "用户听筒异常"),
    CLIENT_DEVICE_SPEAKER("A1004", "用户扬声器异常"),
    CLIENT_DEVICE_GPS_LOCATION("A1005", "用户 GPS 定位异常"),

    CLIENT_SERVICE("A1100", "用户请求服务异常"),
    CLIENT_SERVICE_REQUEST_COUNT_EXCEED("A1101", "请求次数超出限制"),
    CLIENT_SERVICE_REQUEST_CONCURRENT_EXCEED("A1102", "请求并发数超出限制"),
    CLIENT_SERVICE_OPERATION_WAITING("A1103", "用户操作请等待"),
    CLIENT_SERVICE_WEB_SOCKET_EXCEPTION("A1104", "WebSocket 连接异常"),
    CLIENT_SERVICE_WEB_SOCKET_DISCONNECT("A1105", "WebSocket 连接断开"),
    CLIENT_SERVICE_REQUEST_DUPLICATE("A1106", "用户重复请求"),
    CLIENT_SERVICE_REQUEST_NOT_FOUND("A1107", "用户请求未找到"),
    CLIENT_SERVICE_REQUEST_DATA_DUPLICATE("A1108", "用户请求数据重复"),

    /**
     * 二级宏观错误码
     * 系统执行超时
     */
    SYSTEM_TIMEOUT_RUNNING("B0100", "系统执行超时"),
    SYSTEM_TIMEOUT_ORDER_PROCESS("B0101", "系统订单处理超时"),
    SYSTEM_DISASTER_RECOVERY_TRIGGER("B0200", "系统容灾功能被触发"),
    SYSTEM_CURRENT_LIMITING("B0210", "系统限流"),
    SYSTEM_DEMOTION("B0220", "系统功能降级"),
    /**
     * 二级宏观错误码
     * 系统资源异常
     */
    SYSTEM_RESOURCE("B0300", "系统资源异常"),
    SYSTEM_RESOURCE_OVER("B0310", "系统资源耗尽"),
    SYSTEM_RESOURCE_DISK_OVER("B0311", "系统磁盘空间耗尽"),
    SYSTEM_RESOURCE_MEMORY_OVER("B0312", "系统内存耗尽"),
    SYSTEM_RESOURCE_FILE_HANDLE_OVER("B0313", "文件句柄耗尽"),
    SYSTEM_RESOURCE_CONNECT_POOL_OVER("B0314", "系统连接池耗尽"),
    SYSTEM_RESOURCE_THREAD_POOL_OVER("B0315", "系统线程池耗尽"),
    SYSTEM_RESOURCE_ACCESS_DENIED("B0320", "系统资源访问异常"),
    SYSTEM_RESOURCE_READ_DISK_FILE_FAILED("B0321", "系统读取磁盘文件失败"),

    /**
     * 二级宏观错误码
     * 中间件服务出错
     */
    THIRD_MIDDLE("C0100", "中间件服务出错"),
    THIRD_MIDDLE_RPC("C0110", "RPC 服务出错"),
    THIRD_MIDDLE_RPC_NOT_FOUND("C0111", "RPC 服务未找到"),
    THIRD_MIDDLE_RPC_NOT_REGISTER("C0112", "RPC 服务未注册"),
    THIRD_MIDDLE_INTERFACE_NOT_EXIST("C0113", "第三方接口不存在"),
    THIRD_MIDDLE_INTERFACE_ERROR("C0114", "第三方接口异常"),
    THIRD_MIDDLE_MESSAGE("C0120", "消息服务出错"),
    THIRD_MIDDLE_MESSAGE_SEND_FAILED("C0121", "消息投递出错"),
    THIRD_MIDDLE_MESSAGE_CONSUME_FAILED("C0122", "消息消费出错"),
    THIRD_MIDDLE_MESSAGE_SUBSCRIBE_FAILED("C0123", "消息订阅出错"),
    THIRD_MIDDLE_MESSAGE_GROUP_NOT_FOUND("C0124", "消息分组未查到"),
    THIRD_MIDDLE_CACHE("C0130", "缓存服务出错"),
    THIRD_MIDDLE_CACHE_KEY_TOO_LONG("C0131", "key 长度超过限制"),
    THIRD_MIDDLE_CACHE_VALUE_TOO_LONG("C0132", "value 长度超过限制"),
    THIRD_MIDDLE_CACHE_STORAGE_OVER("C0133", "存储容量已满"),
    THIRD_MIDDLE_CACHE_DATA_FORMAT_NOT_SUPPORT("C0134", "不支持的数据格式"),
    THIRD_MIDDLE_CONFIG_SERVICE("C0140", "配置服务出错"),
    THIRD_MIDDLE_NET_RESOURCE_ERROR("C0150", "网络资源服务出错"),
    THIRD_MIDDLE_VPN_ERROR("C0151", "VPN 服务出错"),
    THIRD_MIDDLE_CDN_ERROR("C0152", "CDN 服务出错"),
    THIRD_MIDDLE_DNS_ERROR("C0153", "域名解析服务出错"),
    THIRD_MIDDLE_GATEWAY_ERROR("C0154", "网关服务出错"),
    /**
     * 二级宏观错误码
     * 第三方系统执行超时
     */
    THIRD_TIMEOUT("C0200", "第三方系统执行超时"),
    THIRD_TIMEOUT_RPC("C0210", "RPC 执行超时"),
    THIRD_TIMEOUT_MESSAGE_SEND("C0220", "消息投递超时"),
    THIRD_TIMEOUT_CACHE("C0230", "缓存服务超时"),
    THIRD_TIMEOUT_CONFIG("C0240", "配置服务超时"),
    THIRD_TIMEOUT_MYSQL("C0250", "数据库服务超时"),
    /**
     * 二级宏观错误码
     * 数据库服务出错
     */
    THIRD_DATABASE("C0300", "数据库服务出错"),
    THIRD_DATABASE_TABLE_NOT_FOUND("C0311", "表不存在"),
    THIRD_DATABASE_COLUMN_NOT_FOUND("C0312", "列不存在"),
    THIRD_DATABASE_INCLUDE_SAME_COLUMN("C0321", "多表关联中存在多个相同名称的列"),
    THIRD_DATABASE_DEADLOCK("C0331", "数据库死锁"),
    THIRD_DATABASE_PRIMARY_KEY_CONFLICT("C0341", "主键冲突"),
    THIRD_DATABASE_INSERT_FAILURE("C0351", "数据库插入失败"),
    THIRD_DATABASE_UPDATE_FAILURE("C0352", "数据库更新失败"),
    THIRD_DATABASE_DELETE_FAILURE("C0353", "数据库删除失败"),
    /**
     * 二级宏观错误码
     * 第三方容灾系统被触发
     */
    THIRD_DISASTER_RECOVERY("C0400", "第三方容灾系统被触发"),
    THIRD__CURRENT_LIMITING("C0401", "第三方系统限流"),
    THIRD_DEMOTION("C0402", "第三方功能降级"),
    /**
     * 二级宏观错误码
     * 通知服务出错
     */
    THIRD_NOTICE("C0500", "通知服务出错"),
    THIRD_NOTICE_SMS_FAILED("C0501", "短信提醒服务失败"),
    THIRD_NOTICE_VOICE_FAILED("C0502", "语音提醒服务失败"),
    THIRD_NOTICE_EMAIL_FAILED("C0503", "邮件提醒服务失败"),

    /**
     * 工单 督办错误码
     */
    SUPERVISE_REPEAT("WS0601", "工单重复督办"),
    HAS_BEEN_OVERSEEING("WS0602", "督办已反馈"),
    ASSIGNED("WS0603", "已分配或已办结的工单"),
    CUMULATIVE("WS0604", "已呈报或已（待）办结的工单"),
    COMPLAINT("WS0605", "已转办或已（待）办结的工单"),
    ENDED("WS0606", "工单已办结"),
    REPEATED_FEEDBACK("WS0607", "请勿重复反馈");


    private String code;
    private String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
