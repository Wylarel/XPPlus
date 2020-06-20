# XPPlus
## A Minecraft plugin to manage XP in an advanced way
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://wylarel.com/mit/)
[![Discord](https://img.shields.io/badge/Chat-Discord-blue)](https://discord.gg/7qvmeh2)
[![Versions](https://img.shields.io/badge/Tested%20Versions-1.15.x-orange)](#)

## Permissions
### Players
**bottlexp.use** - Command /bottlexp  
**clearxp.self.use** - Command /clearxp  
**oneclickbottles.use** - Use the one click bottle functionality  
**xpsign.use** - Click on XP Sign  
### Admins
**clearxp.other.use** - Command /clearxp \[player\]  
**xpsign.manage** - Command /xpsign  

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
  message: [String] - Message when using the functionality | Variable: <bottles> | Support chat color (&)
xpsign:
  oncreate: [String] - Message when creating a XP Sign | Variables: <sign> & <location> | Support chat color (&)
  onremove: [String] - Message when removing a XP Sign | Variables: <sign> & <location> | Support chat color (&)
  list: - List of XP Signs, better not to touch
```

## [MIT License](https://wylarel.com/mit/)
```
Copyright (c) 2020 Wylarel

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
