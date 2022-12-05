import numpy as np
import matplotlib.pyplot as plt
from matplotlib import animation

# parameters of the problem
T = 10. # time (s)
m = 1.0 # mass (kg)
ks = 5  # spring constant (N/m)
r0 = 1. # spring equilibrium position (m)

# setting a timestep to be 50 ms
dt = 0.05       # timestep (s)
N = int(T / dt) # number of timesteps that will be simulated

# Allocating arrays for 2D problem: first axis - time. second axis - particle's number. third - coordinate (x or y)
v = np.zeros((N+1, 3, 2)) # velocities
r = np.zeros((N+1, 3, 2)) # positions
f = np.zeros((N+1, 3, 2)) # forces

# initial conditions for 3 particles:
r[0,0] = np.array([0., 2.])  # position of 0th particle
r[0,1] = np.array([2., 0.])  # position of 1st particle
r[0,2] = np.array([-1., 0.]) # position of 2nd particle

def compute_forces(n):
    '''The function computes forces on each particle at time step n'''
    for i in range(3): # iterate over each particle
        for j in range(3): # iterate over each particle
            if i != j:
                rij = r[n,i] - r[n,j]                          # distance vector between particles
                rij_abs = np.linalg.norm(rij)                  # distance between particles
                f[n, i] -= ks * (rij_abs - r0) * rij / rij_abs # force vector between particles (according to Hooke's Law for springs)

## Run dynamics using the Euler Method to solve Newton's Second Law of Motion
for n in range(N):
    compute_forces(n)
    v[n+1] = v[n] + f[n]/m * dt # velocity
    r[n+1] = r[n] + v[n+1] * dt # position

########################################################################
## drawing and animating
########################################################################

# Setup the figure and axes...
fig, ax = plt.subplots(figsize=(6,6))
ax.set(xlim=(-3.5, 3.5), ylim=(-3.5, 3.5), ylabel='meters', xlabel='meters', title='3-Body problem')

scat = ax.scatter(r[0,:,0], r[0,:,1], marker='o', c=['b', 'k', 'r'], s=1000)

def animate(i):
    scat.set_offsets(r[i])

ani = animation.FuncAnimation(fig, animate, frames=N)
plt.close()
## this function will create a lot of *.png files in a folder '3Body_frames'
ani.save('3body.html', writer=animation.HTMLWriter(fps= 1//dt))
