# Asus Tinker Board u-boot

require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot which includes support for the Asus Tinker Board."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCREV = "2.0.7"

SRC_URI = " \
    git://github.com/TinkerBoard/debian_u-boot.git;protocol=https;branch=release \
    "

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(asus-tinker-board|asus-tinker-board-s)"

DEPENDS_append = " bc-native dtc-native"
inherit pythonnative

IDBLOADER = "idbloader.img"

do_compile_append () {
    cp ${B}/spl/${SPL_BINARY} ${B}/${SPL_BINARY}
}

do_deploy_append () {
    # Create bootloader image
    ${B}/tools/mkimage -n ${SOC_FAMILY} -T rksd -d ${B}/spl/${SPL_BINARY} ${DEPLOYDIR}/${IDBLOADER}
    cat ${B}/u-boot.bin >>${DEPLOYDIR}/${IDBLOADER}
}
