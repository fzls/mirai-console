/*
 * Copyright 2020 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 */

@file:Suppress("unused")

package net.mamoe.mirai.console.compiler.common

import net.mamoe.mirai.console.util.ConsoleExperimentalApi
import kotlin.annotation.AnnotationTarget.*

/**
 * 标记一个参数的语境类型, 用于帮助编译器和 IntelliJ 插件进行语境推断.
 */
@ConsoleExperimentalApi
@Target(
    VALUE_PARAMETER,
    PROPERTY, FIELD,
    FUNCTION,
    TYPE, TYPE_PARAMETER
)
@Retention(AnnotationRetention.BINARY)
public annotation class ResolveContext(
    val kind: Kind,
) {
    /**
     * 元素数量可能在任意时间被改动
     */
    public enum class Kind {
        ///////////////////////////////////////////////////////////////////////////
        // ConstantKind
        ///////////////////////////////////////////////////////////////////////////

        PLUGIN_ID, // ILLEGAL_PLUGIN_DESCRIPTION
        PLUGIN_NAME, // ILLEGAL_PLUGIN_DESCRIPTION
        PLUGIN_VERSION, // ILLEGAL_PLUGIN_DESCRIPTION

        COMMAND_NAME, // ILLEGAL_COMMAND_NAME

        PERMISSION_NAMESPACE, // ILLEGAL_COMMAND_NAMESPACE
        PERMISSION_NAME, // ILLEGAL_COMMAND_NAME
        PERMISSION_ID, // ILLEGAL_COMMAND_ID

        RESTRICTED_NO_ARG_CONSTRUCTOR, // NOT_CONSTRUCTABLE_TYPE
    }
}