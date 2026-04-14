import matplotlib.pyplot as plt
import numpy as np

x_waves = np.linspace(0, 4*np.pi, 100)
plt.plot(x_waves, np.sin(x_waves), 'r--', label='Sine')
plt.plot(x_waves, np.cos(x_waves), 'b-', label='Cosine')
plt.annotate('Max', xy=(np.pi/2, 1), xytext=(np.pi/2+1, 1), arrowprops=dict(facecolor='black'))
plt.legend(); plt.savefig('waves.png', dpi=300); plt.show()