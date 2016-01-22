LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := $(call all-java-files-under, java)
LOCAL_DEX_PREOPT := false
LOCAL_PACKAGE_NAME := AssetsTesting
include $(BUILD_PACKAGE)
