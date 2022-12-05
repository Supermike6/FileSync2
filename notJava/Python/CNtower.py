import numpy as np
import matplotlib.pyplot as plt
from matplotlib import animation

# parameters of the problem
T = 10.    # time (s)
m = 0.3    # mass (kg)
g = 9.8    # graviational force constant (m/s^2)
v0x = -0.1 # starting velocity (m/s)
H = 553.   # starting height (m)

# setting a timestep to be 50 ms
dt = 0.05       # timestep (s)
N = int(T / dt) # number of timesteps that will be simulated

# Allocating arrays for 2D problem
v = np.zeros((N+1, 2)) # velocities
r = np.zeros((N+1, 2)) # positions
f = np.zeros((N+1, 2)) # forces

# initial conditions:
r[0] = np.array([0., H])    # position
v[0] = np.array([-v0x, 0.]) # velocity

# the only force is gravity
f[:] = np.array([0., -m * g]) # force (according to Newton's Second Law of Motion, F=ma)

## Run dynamics using the Euler Method to solve Newton's Second Law of Motion
for n in range(N):
    v[n+1] = v[n] + f[n]/m * dt # position
    r[n+1] = r[n] + v[n+1] * dt # velocity

########################################################################
## drawing and animating
########################################################################

# Setup the figure and axes...
fig, ax = plt.subplots(figsize=(8,8))

## Adjust axes limits according to your problem. Here we don't need more than a couple of meters left or right, and 600 meters up
ax.set(xlim=(-2, 2), ylim=(0, 600), xlabel='Position, meters', ylabel='Height, meters', title='Apple falling from CN tower')

## drawing the first data point
scat = ax.scatter(r[0,0], r[0,1], marker='o', c='g', s=200)

## animating
def animate(i):
    scat.set_offsets(r[i])

ani = animation.FuncAnimation(fig, func=animate, frames=N)
## this function will create a lot of *.png files in a folder 'CNtower_frames'
## and create an HTML page with a simulation
# ani.save('CNtower.html', writer=animation.HTMLWriter(fps= 1//dt))
plt.show()
plt.close()
