# Copyright (C) 2015 Romain Perier
# Released under the MIT license (see COPYING.MIT for the terms)

SOC_FAMILY = "rk3288"

require conf/machine/include/tune-cortexa17.inc
require conf/machine/include/soc-family.inc

MACHINEOVERRIDES =. "mali-gpu:mali-midgard:"

PREFERRED_PROVIDER_virtual/kernel = "linux-tinker-board"
PREFERRED_VERSION_linux-tinker-board = "4.4.103"

SERIAL_CONSOLES = "115200;ttyS3"
KERNEL_IMAGETYPE = "zImage"
KBUILD_DEFCONFIG = "miniarm-rk3288_defconfig"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-tinker-board"
SPL_BINARY ?= "u-boot-spl-dtb.bin"

KERNEL_DEVICETREE = "rk3288-miniarm.dtb"
UBOOT_MACHINE = "tinker-rk3288_defconfig"

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += "bluetooth-rk linux-firmware-rtl8723b"