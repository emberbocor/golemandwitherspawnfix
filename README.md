# Golem and Wither Spawn Fix

Build iron golems and withers without clearing the grass, snow or carpets around them first.

In vanilla Minecraft an iron golem or a Wither only spawns when the empty spots next to its build hold nothing but air. A single tuft of grass, a snow layer or a carpet in one of those spots silently stops the summon ([MC-60792](https://bugs.mojang.com/browse/MC-60792)). With this mod those small blocks no longer get in the way, and they vanish together with the rest of the build when the mob appears.

The mod runs on the server only. Players join with a plain vanilla client and still see everything.

Available for NeoForge, Forge and Fabric.

## Features

- **Iron golems spawn over small blocks.** The two empty spots beside the head and the two below the arms may hold grass, flowers, snow, carpets and similar small blocks.
- **Withers spawn over small blocks.** The same goes for the two empty spots below the Wither's arms.
- **Any direction.** Works for upright builds as well as builds lying on their side.
- **Dispensers too.** A dispenser that places the pumpkin or the last wither skeleton skull completes the build when the empty spots hold small blocks.
- **Datapack friendly.** A block tag decides which extra blocks are ignored; servers can add their own.

There is no config file.

## How it works

The iron golem and Wither builds are 3x3 patterns. Next to the iron blocks or soul sand, the pattern has empty spots: four for the iron golem, two for the Wither. Vanilla requires those spots to be air. With the mod, an empty spot also counts as empty when its block:

- has no collision, no block entity and no fluid, such as short grass, flowers, buttons, torches or redstone dust (powder snow and scaffolding do not count: they only lose their collision for some entities), or
- is in the block tag `golemandwitherspawnfix:summon_ignored`.

The tag contains by default:

- all wool carpets (`#minecraft:wool_carpets`)
- moss carpet
- pale moss carpet, when the game has it
- flower pots, empty or with a plant (`#minecraft:flower_pots`)
- snow layers, any height (`minecraft:snow`)

### Adding blocks with a datapack

Add a file `data/golemandwitherspawnfix/tags/blocks/summon_ignored.json` to a datapack. With `"replace": false` your blocks are added to the default list:

```json
{
  "replace": false,
  "values": [
    "minecraft:pointed_dripstone"
  ]
}
```

Run `/reload` or restart the server to apply it.

### What still blocks a summon

- Full blocks, such as stone, dirt or powder snow.
- Scaffolding.
- Other blocks with collision, such as slabs, stairs, fences and pointed dripstone, unless they are in the tag.
- Blocks with a block entity, such as banners, signs and heads.
- Fluids: water, lava and waterlogged blocks.

Only the empty spots inside the 3x3 pattern are checked. Blocks outside it play no part.

### When the mob appears

The game clears the whole 3x3 pattern when the mob spawns. Small blocks in the empty spots are removed with it: they drop nothing, just like the iron blocks, soul sand and heads of the build. Blocks next to the pattern react to the removal as in vanilla; for example, the top half of tall grass growing out of an empty spot disappears with it.

Snow golems are not changed; their build has no empty spots.

## Requirements

| | Forge / NeoForge | Fabric |
|---|---|---|
| Minecraft | 1.20.1 | 1.20 or 1.20.1 |
| Loader | Forge 47.1.0 or newer, or NeoForge 1.20.1 (47.1.x) | Fabric Loader 0.14.21 or newer |
| Other mods | | Fabric API 0.83.0 or newer |
| Jar | `golemandwitherspawnfix-forge-1.20.1-<version>.jar` | `golemandwitherspawnfix-fabric-1.20-1.20.1-<version>.jar` |

On Minecraft 1.20.1, NeoForge still runs Forge mods, so the Forge jar is used for both.

The Fabric version needs Fabric API to load the block tag from the mod.

### Client and server

Install the mod on the server only, on every loader. It adds no items, blocks, entities, sounds, network messages or registries, so the server has nothing a client needs to know about:

- **Forge and NeoForge:** vanilla clients and Forge or NeoForge clients without the mod can join. The mod is marked as server-only, so a client without it still shows the server as compatible in the server list.
- **Fabric:** vanilla clients and Fabric clients without the mod can join.

Players without the mod see the golem or Wither spawn like everyone else. Installing it on a client as well does no harm.

In singleplayer, install it in your own game; the built-in server runs it.

## Removing the mod

The world opens normally. The mod saves nothing of its own. Builds go back to the vanilla rule: the empty spots must be air again.

## Compatibility

- Datapacks can add blocks to `golemandwitherspawnfix:summon_ignored`. A datapack that replaces the tag (`"replace": true`) also removes the default entries.
- Mods that add their own golems or summon patterns are not affected; only the vanilla iron golem and Wither patterns change.
- Dispensers still need the block right in front of them to be air before they place a pumpkin or skull ([MC-217270](https://bugs.mojang.com/browse/MC-217270) is not changed).

## Building from source

```
./gradlew build
```

The jars are written to `forge/build/libs/` and `fabric/build/libs/`.

## License

MIT.
