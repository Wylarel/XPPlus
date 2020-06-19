# XPPlus
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://raw.githubusercontent.com/Wylarel/XPPlus/master/LICENSE)
## A Minecraft plugin to manage XP in an advanced way

**Tested Versions:** 1.15.x

## Configuration
```yaml
bottlexp:
  type: [Integer] - type 0 -> Exponential | type 1 -> Linear
  ratio: [Double] - This is the ratio xp/bottles. If type is set to Exponential (default), 1.0 means that you get the same amount of xp that you have when you transform it in bottles. If type is set to Linear, this is the number of xp bottles that you'll get per level. To avoid abuse, if the number of bottles that the player should get is not an integer, we round down.
  message: [String] - Message when /bottlexp | Variables: <bottles> & <levels> | Support chat color (&)
  error:
    not_enough: [String] - Error message when the player doesn't have enough XP | Support chat color (&)
clearxp:
  self:
    message: [String] - Message when /clearxp on self | Support chat color (&)
    error:
      already_null: [String] - Error message when the player doesn't have XP | Support chat color (&)
  other:
    message: [String] - Message when /clearxp on others | Variable: <player> | Support chat color (&)
    error:
      already_null: [String] - Error message when the targeted player doesn't have XP | Variables: <player> | Support chat color (&)

oneclickbottles: - Sneak + Throw to use all your XP bottles
  enabled: [Boolean] - Is the functionality enabled
  message: [String] Message when using the functionality | Variable: <bottles> | Support chat color (&)
xpsign:
  oncreate: [String] Message when creating a XP Sign | Variables: <sign> & <location> | Support chat color (&)
  onremove: [String] Message when removing a XP Sign | Variables: <sign> & <location> | Support chat color (&)
  list: - List of XP Signs, do not touch
```
