# PackwizWrapper

A small wrapper for `packwiz-installer-bootstrap.jar`, intended to be used as a MultiMC "pre-launch command". In such a case, `PackwizWrapper.jar` and `packwiz-installer-bootstrap.jar` are both to be placed in the `.minecraft` folder of a given MultiMC instance.

It will run `packwiz-installer-bootstrap.jar` twice - once for each URL passed to it. The syntax is explained below.

Originally intended for usage alongside [Sinytra Connector](https://github.com/Sinytra/Connector), a compatibility layer that allows running Fabric mods on MinecraftForge.

MultiMC pre-launch command syntax:
```
"$INST_JAVA" -jar PackwizWrapper.jar "$INST_JAVA" "$INST_DIR" "https://example.com/packwiz/<modpack_fabric>/pack.toml" "https://example.com/packwiz/<modpack_forge>/pack.toml"
```

- `"$INST_JAVA"`, `"$INST_DIR"` - MultiMC "custom command" variables
- `"https://example.com/packwiz/<modpack_fabric>/pack.toml"` - `pack.toml` of the packwiz repo containing the Fabric mods / configs
- `"https://example.com/packwiz/<modpack_forge>/pack.toml"` - `pack.toml` of the packwiz repo containing the Forge mods / configs
