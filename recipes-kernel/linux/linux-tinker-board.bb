FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

LINUX_VERSION = "4.4.103"

SRC_URI = " \
    git://github.com/TinkerBoard/debian_kernel.git;protocol=https;branch=release \
    "

SRCREV = "2.0.7"

require recipes-kernel/linux/linux-yocto.inc

PV = "${LINUX_VERSION}"

S = "${WORKDIR}/git"

KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "(asus-tinker-board|asus-tinker-board-s)"
