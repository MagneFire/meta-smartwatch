require recipes-kernel/linux/linux.inc
inherit gettext

SECTION = "kernel"
SUMMARY = "Android kernel for the LG G Watch"
HOMEPAGE = "https://android.googlesource.com/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "dory"

SRC_URI = "git://android.googlesource.com/kernel/msm;branch=android-msm-dory-3.10-lollipop-mr1-wear-release;protocol=https \
    file://defconfig \
    file://img_info \
    file://0001-scripts-dtc-Remove-redundant-YYLOC-global-declaratio.patch \
    file://0002-Backport-mainline-4.1-Bluetooth-subsystem.patch \
    file://0003-bluesleep-Use-kernel-s-HCI-events-instead-of-proc-bl.patch \
    file://0004-msm_pwm_vibrator-Convert-timed_output-APIs-to-ff_mem.patch \
    file://0005-synaptics_i2c_rmi4-Adds-a-wakelock-when-the-screen-i.patch \
    file://0006-ARM-uaccess-remove-put_user-code-duplication.patch"
SRCREV = "9baeef88e425be653d8287f141ee209d78b918b3"
LINUX_VERSION ?= "3.10"
PV = "${LINUX_VERSION}+lollipop"
S = "${WORKDIR}/git"
B = "${S}"

do_install:append() {
    rm -rf ${D}/usr/src/usr/
}

BOOT_PARTITION = "/dev/mmcblk0p15"

inherit mkboot old-kernel-gcc-hdrs
