# Animation Setup Instructions

## Overview
This document provides detailed step-by-step instructions for adding animations to the PowerPoint slide. The animations must be configured manually in Microsoft PowerPoint due to the complexity of PowerPoint's animation XML structure.

## Prerequisites
- Microsoft PowerPoint (Microsoft 365 desktop version recommended)
- The file: `How_We_Learn_OnePager_Animated.pptx`

## Step-by-Step Animation Configuration

### 1. Open the Animation Pane
1. Open `How_We_Learn_OnePager_Animated.pptx` in PowerPoint
2. Go to **Animations** tab in the ribbon
3. Click **Animation Pane** (usually on the right side)

### 2. Group Elements for Animation
Before adding animations, you may need to group related elements:

**Step 1 Group:**
- Card background
- Face icon
- "Stakeholder Mapping" title
- "Who needs what — and why" label

**Step 2 Group:**
- Card background
- Server icon
- "Current State" title
- "Apps, data, tech — one map" label

**Step 3 Group:**
- Card background
- Conveyor icon
- "Business Process" title
- "How work really flows" label

**Step 4 Group:**
- Card background
- Magnifier icon
- "Reverse Engineering" title
- "Trace data and code to the truth" label

### 3. Add Animations in Sequence

#### Animation 1: Title + Subtitle
1. Select both the title ("How We Learn...") and subtitle ("Know Before You Build")
2. Click **Add Animation** > **Entrance** > **Appear**
3. Set **Start**: On Click
4. Set **Duration**: 0.25 seconds (Fast)

#### Animation 2: Step 1 Group
1. Select the Step 1 group (all elements of first card)
2. Click **Add Animation** > **Entrance** > **Wipe**
3. Click **Effect Options** > **From Left**
4. Set **Start**: On Click
5. Set **Duration**: 0.5 seconds (Medium)

#### Animation 3: Arrow 1
1. Select the first arrow (between Step 1 and Step 2)
2. Click **Add Animation** > **Entrance** > **Wipe**
3. Click **Effect Options** > **From Left**
4. Set **Start**: After Previous
5. Set **Duration**: 0.35 seconds

#### Animation 4: Step 2 Group
1. Select the Step 2 group
2. Click **Add Animation** > **Entrance** > **Wipe**
3. Click **Effect Options** > **From Left**
4. Set **Start**: On Click
5. Set **Duration**: 0.5 seconds (Medium)

#### Animation 5: Arrow 2
1. Select the second arrow (between Step 2 and Step 3)
2. Click **Add Animation** > **Entrance** > **Wipe**
3. Click **Effect Options** > **From Left**
4. Set **Start**: After Previous
5. Set **Duration**: 0.35 seconds

#### Animation 6: Step 3 Group
1. Select the Step 3 group
2. Click **Add Animation** > **Entrance** > **Wipe**
3. Click **Effect Options** > **From Left**
4. Set **Start**: On Click
5. Set **Duration**: 0.5 seconds (Medium)

#### Animation 7: Arrow 3
1. Select the third arrow (between Step 3 and Step 4)
2. Click **Add Animation** > **Entrance** > **Wipe**
3. Click **Effect Options** > **From Left**
4. Set **Start**: After Previous
5. Set **Duration**: 0.35 seconds

#### Animation 8: Step 4 Group
1. Select the Step 4 group
2. Click **Add Animation** > **Entrance** > **Wipe**
3. Click **Effect Options** > **From Left**
4. Set **Start**: On Click
5. Set **Duration**: 0.5 seconds (Medium)

#### Animation 9: "What You Get" Panel
1. Select the blue panel on the right (including title and bullets)
2. Click **Add Animation** > **Entrance** > **Fade**
3. Set **Start**: On Click
4. Set **Duration**: 0.4 seconds

#### Animation 10-13: Panel Bullets
1. Select the first bullet in "What You Get" panel
2. Click **Add Animation** > **Entrance** > **Appear**
3. Set **Start**: On Click
4. Set **Duration**: 0.2 seconds
5. Repeat for each of the 4 bullets

### 4. Optional Enhancement Animations

#### Pulse on Face Icon (Step 1)
1. Select the face icon in Step 1
2. Click **Add Animation** > **Emphasis** > **Pulse**
3. Set **Start**: After Previous (after Step 1 entrance)
4. Set **Duration**: 0.5 seconds
5. Set **Repeat**: 1 time

#### Spin on Magnifier (Step 4)
1. Select the magnifying glass icon in Step 4
2. Click **Add Animation** > **Emphasis** > **Spin**
3. Set **Start**: After Previous (after Step 4 entrance)
4. Set **Duration**: 0.3 seconds
5. In **Effect Options** > **Amount**: 15° (quarter spin)

## Verification Checklist

Use this checklist to verify your animation setup:

- [ ] Title and subtitle appear together on first click
- [ ] Step 1 wipes in from left on second click
- [ ] Arrow 1 wipes in automatically after Step 1
- [ ] Step 2 wipes in from left on third click
- [ ] Arrow 2 wipes in automatically after Step 2
- [ ] Step 3 wipes in from left on fourth click
- [ ] Arrow 3 wipes in automatically after Step 3
- [ ] Step 4 wipes in from left on fifth click
- [ ] "What You Get" panel fades in on sixth click
- [ ] Each bullet appears individually on clicks 7-10
- [ ] (Optional) Face icon pulses once after appearing
- [ ] (Optional) Magnifier spins 15° after appearing
- [ ] All animations have smooth timing
- [ ] No elements overlap or flash incorrectly

## Testing Your Animations

1. Go to **Slide Show** > **From Beginning** (or press F5)
2. Click through each animation step
3. Verify timing and sequencing
4. Make adjustments in Animation Pane as needed

## Adjusting Timing

If animations feel too fast or slow:
1. Select the animation in the Animation Pane
2. Click the dropdown arrow next to it
3. Select **Timing...**
4. Adjust **Duration** and **Delay** as needed

## Common Issues

**Issue**: Elements appear before their animation
**Solution**: Ensure "Start" is set to "On Click" or "After Previous" for the first appearance

**Issue**: Multiple elements animate together when they shouldn't
**Solution**: Ungroup them and set individual animations

**Issue**: Animations happen in wrong order
**Solution**: Drag animations in the Animation Pane to reorder them

## Support

For PowerPoint animation help:
- Press F1 in PowerPoint for Help
- Search for "PowerPoint animations" in Microsoft Support
- Refer to the main README.md for design specifications

---

**Note**: Save your work frequently when configuring animations. PowerPoint can be sensitive to complex animation setups.
