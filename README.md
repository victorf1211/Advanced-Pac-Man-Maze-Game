## Advanced Pac‑Man Maze Game (Java, Swing)

A Java Swing arcade game inspired by Pac‑Man featuring custom maze layouts, AI‑driven enemy behavior, and character abilities. Built in close collaboration with a client to prototype new game modes and refine creative direction.

### Features
- **Custom maze**: Grid‑based map with collectible dots; win by clearing all dots.
- **AI enemy**: Red enemy chases the player using pursuit logic constrained by walls.
- **Abilities system**:
  - **Ghost**: Temporary speed boost with cooldown.
  - **Flash**: Short directional blink; purchasable with points.
- **In‑game shop**: Earn and spend points to unlock/activate abilities.
- **Arcade flow**: Explore, shop, start level, evade enemy, clear dots, win/lose screens.

### Controls
- **W/A/S/D**: Move up/left/down/right.
- **Skill button**: Click the on‑screen “Skill” button to activate the current ability.
- Move to the shop (top‑right hub) to buy/switch skills; move to the map area (bottom‑left hub) to start the level.

## Getting Started

### Prerequisites
- JDK 8+ installed and on your PATH.

### Run (Windows PowerShell)
```powershell
cd "/path/to/Advanced Pac-Man Maze Game"
javac *.java
java IA
```

### Run (macOS/Linux)
```bash
cd "/path/to/Advanced Pac-Man Maze Game"
javac *.java
java IA
```

## Gameplay
- **Objective**: Collect all dots to win while avoiding the red enemy.
- **Enemy**: Continuously moves toward your position while respecting walls.
- **Ghost**: Brief speed increase; cooldown auto‑ticks each second.
- **Flash**: Blink in your current movement direction after purchase; then switch to it in the shop.

## Technical Overview
- **Entry point**: `IA.java` → `new JF()`
- **Core UI/logic**: `JF.java` (window, map, movement, collisions, enemy AI, shop, abilities, timers)
- **Player model**: `character.java` (speed, points, current `Skill`)
- **Abilities**: `Skill.java` (name + cooldown)

## Customization
- **Maze**: Edit `map1n` in `JF.java` (1 = wall, 0 = dot). Cells assume 50px walls and 6px dots in a 50px grid.
- **Abilities**: Add in `Skill.java` and handle activation in the `Skill` button logic in `JF.java`.
- **Enemy**: Tweak pursuit rules in `JF.java` inside the enemy loop.

## Roadmap Ideas
- Multiple levels, smarter pathfinding (A*), more power‑ups/enemies, audio/animation, high scores.

## License
Unspecified.

## Credits
Developed in collaboration with the client: requirements gathering, iterative prototypes, and alignment with their creative vision.