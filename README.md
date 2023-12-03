# PackwizWrapper

A small wrapper for `packwiz-installer-bootstrap.jar`, intended to be used as a MultiMC "pre-launch command". In such a case, `PackwizWrapper.jar` is to be placed in the `.minecraft` folder of a given MultiMC instance.

It will run `packwiz-installer-bootstrap.jar` twice - once in the instance folder of a MultiMC instance, and once in the `.minecraft` folder of the same instance. A copy of `packwiz-installer-bootstrap.jar` must be placed in both folders.

Originally intended for automatically updating GTNewHorizon's [LWJGL3ify](https://github.com/GTNewHorizons/lwjgl3ify), which has custom patches that must be placed and updated in the MultiMC instance folder.

MultiMC pre-launch command syntax:
```
"$INST_JAVA" -jar PackwizWrapper.jar "$INST_JAVA" "$INST_DIR" "$INST_MC_DIR" "https://example.com/packwiz/<modpack-mmc>/pack.toml" "https://example.com/packwiz/<modpack>/pack.toml"
```

- `"$INST_JAVA"`, `"$INST_DIR"`, `"$INST_MC_DIR"` - MultiMC "custom command" variables
- `"https://example.com/packwiz/<modpack-mmc>/pack.toml"` - `pack.toml` of the packwiz repo containing the files to be placed in the MultiMC instance folder ("patches" dir, "mmc-pack.json" file, etc.)
- `"https://example.com/packwiz/<modpack>/pack.toml"` - `pack.toml` of the packwiz repo containing the files to be placed in the `.minecraft` folder ("config", "mods", etc.)
